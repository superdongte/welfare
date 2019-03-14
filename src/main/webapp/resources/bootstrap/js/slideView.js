/*

	2009.03.06
	SlideView Component
	developled by Robin at ELFVision and PageTalks
	used mainly in the WUSESKY Project
	
	Visit Robin's:
	http://www.elfvision.com/
	http://pagetalks.com/
	
	and See our Project
	http://www.wusesky.com/

*/

jQuery.iSlideView = {
	build: function(user_options) {
		var defaults = {
			thumbPrefix: "thumb_",
			slideBy : 1,
			speed: 350
		};
		return jQuery(this).each(function() {
			var options = jQuery.extend(defaults, user_options);
			var config;
			
			var x =jQuery(this);
			var list  = x.find(".slideView");
			var links = list.find("a");
			var images = list.find("img");
			
			//Prepare DOM
			x.prepend("<span class='desc'></span><span class='arrowL arrow'><</span><div class='wrap'><ul class='thumbList'></ul></div><span class='arrowR arrow'>></span>");
			var thumbList = x.find(".thumbList");
			var i=0;
			images.each(function() {
				var l = jQuery(this);
				thumbList.append("<li>"+
					"<a href='#' id='"+ (i+1) +"'><img src='"+getThumbName(l.attr("src"),options.thumbPrefix)+"' alt='"+l.attr("alt")+"' /></a></li>");
				i++;
			});
			
			//Force to hide overflow
			x.css("overflow","hidden");
			
			//Attach events
			var arrow = x.find(".arrow");
			var back = x.find(".arrowL");
			var next = x.find(".arrowR");
			var desc = x.find(".desc");
			var liW = thumbList.find("li").width();
			var xW = x.width();
			var xH = x.height();
			var thumbW = thumbList.width(); //458px
			var li = thumbList.find("li");
			var tLink = thumbList.find("a");
			var totalW = li.length * liW;
			var xTotalH = li.length * xH;
			
			back.hide();
			x.find(".wrap").fadeTo("fast",0.6);
			
			desc.text(images.eq(0).attr("alt")).fadeTo("fast",0.6).hover(function() {
				jQuery(this).fadeTo("fast",0.9);
			},function() {
				jQuery(this).fadeTo("fast",0.6);
			});
			
			list.css("height",xTotalH);
			thumbList.css( "width", totalW );
			
			var Pointer = 0;
			var total = li.length;
			
			next.click(function() {
				var offsetL =  parseInt(thumbList.css("left")) - liW * options.slideBy;
				
				thumbList.animate({
					left: offsetL + "px"
				},options.speed,function() {
					if(Pointer==total-1) {
						next.hide();
					}
					desc.text(images.eq(Pointer).attr("alt"));
					var offsetT = - (xH * Pointer);
					
					list.animate({
						top: offsetT
					},options.speed);
				});
				Pointer++;
				if(Pointer!=0) {
					back.show().fadeTo("fast",0.6);
				}
				
			});
			
			back.click(function() {
				var offsetL =  parseInt(thumbList.css("left")) + liW * options.slideBy;
				thumbList.animate({
					left: offsetL + "px"
				},options.speed,function() {
					if(Pointer==0) {
						back.hide();
						next.show().fadeTo("fast",0.6);
					}
					desc.text(images.eq(Pointer).attr("alt"));
					var offsetT = - (xH * Pointer);
					list.animate({
						top: offsetT
					},options.speed);
					
				});
				
				Pointer--;
			});
			
			tLink.hover(function() {
				var id = $(this).attr("id")-1;				
				var offsetT = - (xH * id);
				desc.text(images.eq(id).attr("alt"));
					list.animate({
						top: offsetT
					},options.speed);
			},function() {
				var offsetT = - (xH * Pointer);
				desc.text(images.eq(Pointer).attr("alt"));
				list.animate({
					top: offsetT
				},options.speed);
			});
			
			thumbList.hover(function() {
				x.find(".wrap").fadeTo("fast",0.8);
			},
			function() {
				x.find(".wrap").fadeTo("fast",0.6);
			});
			
			arrow.fadeTo("fast",0.6).hover(function() {
				jQuery(this).fadeTo("fast",0.9);
			},
			function() {
				jQuery(this).fadeTo("fast",0.6);
			}
			);
			
		});
	}
}

jQuery.fn.slideView = jQuery.iSlideView.build;

//Helping functions

function getThumbName(n,prefix) {
	var arr = n.split("/");
	var tl = n.length;
	var w = arr[arr.length-1].length;
	return n.substr(0,tl-w-1)+"/"+prefix+arr[arr.length-1];
}

function focusTo(pointer,list,height,speed,desc,text) {
	//alert(pointer);
	var id = pointer - 1;
	var offsetT = - (height * id);
	list.animate({
		top: offsetT
	},speed);
	desc.text(text);
}
