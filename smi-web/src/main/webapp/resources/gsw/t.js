"undefined"==typeof CE2&&(CE2={}),CE2.browser=function(){var e=navigator.userAgent;CE2.opera=CE2.ie=CE2.chrome=CE2.safari=CE2.firefox=!1;var t="unknown";return CE2.w.opera&&"function"==typeof CE2.w.opera.version?(t="opera",CE2.opera=!0,CE2.operaVersion=parseInt(opera.version(),10)):/\bMSIE\b/.test(e)?(t="ie",CE2.ie=!0,CE2.ieVersion=parseInt(/MSIE (\d+)\.\d+/.exec(navigator.userAgent)[1],10),CE2.ieQuirksMode="BackCompat"==document.compatMode):/\b(iPhone|iP[ao]d)\b/.test(e)?(t="iphone",CE2.iphone=!0,CE2.webkit=!0):/\bChrome\b/.test(e)?(t="chrome",CE2.chrome=!0,CE2.webkit=!0):/AppleWebKit/.test(navigator.appVersion)?(t="safari",CE2.safari=!0,CE2.webkit=!0):/Mozilla/i.test(e)&&!/compatible|webkit/i.test(e)&&(t="firefox",CE2.firefox=!0),CE2.webkit&&(CE2.webkitVersion=parseInt(/AppleWebKit\/(\d+)/.exec(e)[1],10)),t}(),CE2.findByClass=function(e){var t,n,i,o,r=[],s=CE2.d.body;if(s.getElementsByClassName?i=s.getElementsByClassName(e):s.querySelectorAll&&(i=s.querySelectorAll("."+e)),i)for(t=0;n=i[t++];)r.push(n);else for(i=s.getElementsByTagName("*"),o=RegExp("(^|\\s)"+e+"($|\\s)"),t=0;n=i[t++];)n.className&&o.test(n.className)&&r.push(n);return r},CE2.formatClass=function(e){var t=e.className;if(t&&"string"==typeof t)return(t=CE2.strip(t.replace(/(\s|^)-ce-capture\b/g,"")).split(/\s+/)).sort(),t.join(" ")},CE2.href=function(e){if(!CE2.ie)return e.getAttribute("href");var t=e.outerHTML.match(CE2.re.href);return t?CE2.strip(t[1]):void 0},CE2.map=function(e,t,n){for(var i=[],o=0,r=e.length;o<r;o++)i.push(t.call(n,e[o]));return i},CE2.spansLines=function(e){return e.getClientRects&&e.getClientRects().length>1},CE2.eventCoords=function(e,t){if(null==e.pageX){var n=CE2.scroll(t);return[e.clientX+n.left,e.clientY+n.top]}return[e.pageX,e.pageY]},CE2.contains=function(e,t){if(e==t)return!0;if("function"==typeof e.contains)return e.contains(t);var n=t;do{n=n.parentNode}while(n&&n!=document.body&&n!=e);return n==e},CE2.arrayContains=function(e,t){var n,i;if(e&&e.length)for(n=0;i=e[n++];)if(CE2.contains(i,t))return i},CE2.isVML=function(e){return"string"==typeof e.tagUrn&&e.tagUrn.indexOf("vml")>=0},CE2.bind=function(e,t){var n=e[t];return function(){try{return n.apply(e,arguments)}catch(e){}}},CE2.TIME_RANGES=[500,1e3,1500,2e3,3e3,4e3,5e3,6e3,8e3,1e4,15e3,2e4,3e4,35e3,4e4,6e4,9e4,12e4,18e4,24e4,3e5,42e4,6e5,9e5,12e5,15e5,18e5,24e5,3e6,36e5,72e5,108e5,Number.MAX_VALUE],CE2.getTimeRange=function(e){for(var t=CE2.TIME_RANGES,n=0,i=t.length;n<i;n++)if(e<t[n]&&(0==n||e>=t[n-1]))return n+1},CE2.eventWindow=function(e){return e.source||e.view||e.srcElement.ownerDocument.parentWindow},CE2.getStyle=function(e){var t=CE2.w,n=t.getComputedStyle;return n?n.call(t,e,null):e.currentStyle},"undefined"==typeof CE2&&(CE2={}),CE2.re=function(){var e="[\\s\\u00a0\\u2028\\u2029]+";return{whitespace:RegExp(e,"g"),strip:RegExp("^"+e+"|"+e+"$","g"),href:/\bhref="(.*?)"/i,ipHost:/^([\d\.]+|\[[a-f\d:]+\])$/i}}(),CE2.strip=function(e,t){var n=e.replace(CE2.re.strip,"");return t?n.replace(CE2.re.whitespace," "):n},CE2.hash=function(e){var t,n,i=0;if(0==e.length)return i;for(t=0,n=e.length;t<n;t++)i=(i<<5)-i+e.charCodeAt(t),i|=0;return i},"undefined"==typeof CE2&&(CE2={}),CE2.SPIRAL=[[.4,.4],[.5,.4],[.5,.5],[.4,.5],[.3,.5],[.3,.4],[.3,.3],[.4,.3],[.5,.3],[.6,.3],[.6,.4],[.6,.5],[.6,.6],[.5,.6],[.4,.6],[.3,.6],[.2,.6],[.2,.5],[.2,.4],[.2,.3],[.2,.2],[.3,.2],[.4,.2],[.5,.2],[.6,.2],[.7,.2],[.7,.3],[.7,.4],[.7,.5],[.7,.6],[.7,.7],[.6,.7],[.5,.7],[.4,.7],[.3,.7],[.2,.7],[.1,.7],[.1,.6],[.1,.5],[.1,.4],[.1,.3],[.1,.2],[.1,.1],[.2,.1],[.3,.1],[.4,.1],[.5,.1],[.6,.1],[.7,.1],[.8,.1],[.8,.2],[.8,.3],[.8,.4],[.8,.5],[.8,.6],[.8,.7],[.8,.8],[.7,.8],[.6,.8],[.5,.8],[.4,.8],[.3,.8],[.2,.8],[.1,.8],[0,.8],[0,.7],[0,.6],[0,.5],[0,.4],[0,.3],[0,.2],[0,.1],[0,0],[.1,0],[.2,0],[.3,0],[.4,0],[.5,0],[.6,0],[.7,0],[.8,0],[.9,0],[.9,.1],[.9,.2],[.9,.3],[.9,.4],[.9,.5],[.9,.6],[.9,.7],[.9,.8],[.9,.9],[.8,.9],[.7,.9],[.6,.9],[.5,.9],[.4,.9],[.3,.9],[.2,.9],[.1,.9],[0,.9]],CE2.dynamicKey="cedk"+(""+Math.random()).replace(/\D/g,""),CE2.scrollRootKey="cesrk"+(""+Math.random()).replace(/\D/g,""),CE2.initScrollTracking=function(){CE2.strictAnchorSearch=!0,CE2.lastRecordedScroll=null,CE2.lastRecordedTime=0,CE2.lastRecordedY=0,CE2.idleAt=null,CE2.idleSince=(new Date).getTime()},CE2.scroll=function(e){var t,n,i=CE2.scrollRootKey;if(e=e||CE2.w,n=e.document,!(i in e))try{e[CE2.scrollRootKey]=CE2.findScrollRoot(n)}catch(t){e[CE2.scrollRootKey]=null}return t=e[CE2.scrollRootKey],null==e.pageXOffset?(t=t||("BackCompat"==n.compatMode?n.body:n.documentElement),{left:t.scrollLeft,top:t.scrollTop,width:t.offsetWidth,height:t.offsetHeight}):{left:t?t.scrollLeft:e.pageXOffset,top:t?t.scrollTop:e.pageYOffset,width:e.innerWidth,height:e.innerHeight}},CE2.shouldRecordScroll=function(e){var t=e.top,n=e.height,i=t+":"+n,o=(new Date).getTime();if(i==CE2.lastRecordedScroll)return!1;if(i==CE2.idleAt){if(o-CE2.idleSince>=800)return CE2.lastRecordedScroll=i,CE2.lastRecordedTime=o,CE2.lastRecordedY=t,!0}else CE2.idleAt=i,CE2.idleSince=o;return null==CE2.lastRecordedScroll||Math.abs(t-CE2.lastRecordedY)>n/2&&o-CE2.lastRecordedTime>=1600?(CE2.lastRecordedScroll=i,CE2.lastRecordedTime=o,CE2.lastRecordedY=t,!0):void 0},CE2.findAnchor=function(e,t){if(!CE2.d.elementFromPoint)return t(e);var n,i,o,r,s=0,a=CE2.strictAnchorSearch,l=e.width,c=e.height,u=function(){if(n=CE2.SPIRAL[s++]){if(o=(n[0]+.1*Math.random())*l,r=(n[1]+.1*Math.random())*c,i=CE2.elementFromPoint(o,r,e),CE2.isAnchorElement(i,e,a))return t(e,i);setTimeout(u,0)}else s=0,CE2.strictAnchorSearch=a=!1,setTimeout(u,0)};setTimeout(u,0)},CE2.isStatic=function(e){var t,n=CE2.dynamicKey;if(e[n])return!1;for(;e&&e!=CE2.d&&e!=CE2.d.documentElement&&e!=CE2.d.body;e=e.parentNode)if((t=CE2.getStyle(e))&&("absolute"==t.position||"fixed"==t.position))return!(e[n]=!0);return!0},CE2.elementFromPointAbsolute=function(e,t,n){var i=CE2.d.elementFromPoint(e+n.left,t+n.top);return i.nodeType===i.TEXT_NODE?i.parentNode:i},CE2.elementFromPointRelative=function(e,t){return CE2.d.elementFromPoint(e,t)},CE2.elementFromPoint=function(){if(CE2.d.elementFromPoint)return CE2.webkit&&CE2.webkitVersion<533||CE2.opera&&CE2.operaVersion<10?CE2.elementFromPoint=CE2.elementFromPointAbsolute:CE2.elementFromPoint=CE2.elementFromPointRelative,CE2.elementFromPoint.apply(CE2,arguments)},CE2.isAnchorElement=function(e,t,n){if(!e||!e.nodeName)return!1;if(e==CE2.d||e==CE2.d.documentElement||e==CE2.d.body)return!1;if(CE2.isVML(e))return!1;if(n){if(!CE2.isStatic(e))return!1;if(CE2.getBox(e).height>2*t.height)return!1}return!0},CE2.findScrollRoot=function(e){if(e.querySelectorAll&&"number"==typeof e.body.scrollHeight){var t,n,i,o,r,s,a=e.body,l=e.querySelectorAll("body, body > *, body > * > *, body > * > * > *"),c=a.getElementsByTagName("*").length,u=(document.body.scrollHeight,5e-324);for(t=0,n=Math.min(7e3,l.length);t<n;t++)i=l[t],r=CE2.getStyle(i),0!=i.clientWidth&&0!=i.clientHeight&&"none"!=r.display&&"hidden"!=r.visibility&&"visible"!=r.overflow&&"visible"!=r.overflowY&&"hidden"!=r.overflow&&"hidden"!=r.overflowY&&(i.getElementsByTagName("*").length/c<.5||i.clientHeight>window.innerHeight||(o=function(e,t){for(var n=0;e!=t;e=e.parentNode)n++;return n}(i,a),(!s||o>u)&&(s=i,u=o)));return s}},"undefined"==typeof CE2&&(CE2={}),CE2.S16_0=32768,CE2.Package=function(){for(var e,t,n,i,o=[],r={},s=arguments,a=0,l=s.length;a<l;a++)t=(e=s[a])[0],n=e[1],i=e[2],o.push(t),r[t]={t:n,s:i};this.props=r,this.propList=o,this.overBudget=[],this.surplus=0},CE2.Package.prototype={set:function(e,t){var n=this.props[e],i=0;n&&("s"==n.t?(n.ov=t,n.v=t+""?CE2.utf8Trim(t+"",255):"",i=n.s-n.v.length,this.surplus+=i,i<0&&this.overBudget.push(n)):(n.ov=t,n.v=isNaN(parseInt(t,10))?0:parseInt(t,10)))},trimStrings:function(){var e=this.surplus,t=this.overBudget;if(!(e>=0)){var n=Math.abs(e)/t.length,i=Math.floor(n)==n?0:1;n=Math.floor(n);for(var o=0,r=t.length,s=null;o<r;o++)(s=t[o]).v=CE2.utf8Trim(s.v,s.v.length-n-i),i&&(i=0)}},toString:function(){this.trimStrings();for(var e,t,n=this.props,i=this.propList,o=[],r=0,s=i.length;r<s;r++)t=(e=n[i[r]]).v,"s"==e.t?null==t?o.push("\0"):(o.push(CE2.pack(1,t.length)),o.push(t)):null==t?o.push(CE2.pack(e.s,0)):o.push(CE2.pack(e.s,t));return o.join("")}},CE2.pack=function(e,t){for(var n="",i=0;i<e;i++)n+=String.fromCharCode(t>>8*i&255);return n},CE2.utf8=function(e){return unescape(encodeURIComponent(e))},CE2.utf8Trim=function(e,t){var n=e.substr(0,t),i=CE2.utf8(n);if(i==n)return n;for(var o=n.length-1;i.length>t;o--)i=CE2.utf8(n.substr(0,o));return i},CE2.base64Alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_=",CE2.base64=function(e){for(var t,n,i,o,r,s,a,l=CE2.base64Alphabet,c=[],u=0,E=e.length;u<E;)o=(t=e.charCodeAt(u++))>>2,r=(3&t)<<4|(n=e.charCodeAt(u++))>>4,s=(15&n)<<2|(i=e.charCodeAt(u++))>>6,a=63&i,isNaN(n)?s=a=64:isNaN(i)&&(a=64),c.push(l.charAt(o)+l.charAt(r)),64!=s&&(c.push(l.charAt(s)),64!=a&&c.push(l.charAt(a)));return c.join("")},"undefined"==typeof CE2&&(CE2={}),CE2.getBox=function(e,t,n){if(t=t||{},"AREA"==e.nodeName){(i=CE2.boxForArea(e))&&(t.left=i.left,t.top=i.top,t.width=i.width,t.height=i.height)}else if(e.getBoundingClientRect){var i=e.getBoundingClientRect(),o=CE2.scroll();t.left=Math.floor(i.left+o.left),t.top=Math.floor(i.top+o.top),CE2.webkit&&CE2.webkitVersion<533&&"relative"==e.style.position&&(t.left+=parseInt(e.style.left,10),t.top+=parseInt(e.style.top,10)),t.width=Math.floor(i.width||i.right-i.left),t.height=Math.floor(i.height||i.bottom-i.top)}else{t.width=e.offsetWidth,t.height=e.offsetHeight;var r=e,s=0,a=0;do{s+=r.offsetLeft||0,a+=r.offsetTop||0,r=r.offsetParent}while(r);t.left=Math.floor(s),t.top=Math.floor(a)}if(t.pageX=t.left,t.pageY=t.top,n){var l=CE2.getBox(n);t.left-=l.pageX,t.top-=l.pageY}return t},CE2.boxForArea=function(e){var t=CE2.imageForArea(e);if(t){var n=CE2.getBox(t),i=CE2.areaBounds(e,n);return i?{left:n.left+i.left,top:n.top+i.top,width:i.width,height:i.height}:void 0}},CE2.imageForArea=function(e){var t,n,i=RegExp("(^|#)"+e.parentNode.name,"i"),o=e.ownerDocument.getElementsByTagName("IMG");for(t=0;n=o[t++];)if(i.test(n.useMap))return n},CE2.areaBounds=function(e,t){var n,i,o,r=CE2.areaLength,s=Math.min(t.width,t.height),a=CE2.map(CE2.strip(e.coords,!0).split(/[^\d\.%]+/),function(e){return r(e,s)});if(!/circle/i.test(e.shape)){n=[],i=[];for(var l=0,c=a.length;l<c;l++)l%2?i.push(a[l]):n.push(a[l]);var u=Math.min.apply(null,n),E=Math.max.apply(null,n),h=Math.min.apply(null,i);return{left:u,top:h,width:E-u,height:Math.max.apply(null,i)-h}}if(a.length>=3)return n=a[0],i=a[1],o=a[2],{left:n-o,top:i-o,width:2*o,height:2*o}},CE2.areaLength=function(e,t){var n=parseInt(e,10);return-1!=e.indexOf("%")&&(n*=.01*t),isNaN(n)?null:n},CE2.getPageCoords=function(e){e.pageX=e.left,e.pageY=e.top;var t,n;e.parentID&&(t=CE2.d.getElementById(e.parentID+""))&&(n=CE2.getBox(t),e.pageX+=n.pageX,e.pageY+=n.pageY)},"undefined"==typeof CE2&&(CE2={}),CE2.fingerprint=function(e){var t,n,i,o,r,s={type:CE2.tagTypes[e.nodeName.toLowerCase()]||0};return(t=CE2.getName(e))&&(s.name=t),(n=CE2.getData(e))&&(s.data=n),(i=e.getAttribute("id"))&&(s.id=i),(o=CE2.getCEID(e))&&(s.ceid=o),(r=CE2.getParentID(e))&&(s.parentID=r),CE2.getBox(e,s,r?e.parentNode:null),s},CE2.getParentID=function(e){var t=e.parentNode,n=null;if(t&&t.getAttribute&&t!=e.ownerDocument.body)return(n=t.id)&&t.ownerDocument.getElementById(n)==t?n:CE2.getCEID(t)||null},CE2.getCEID=function(e){return e.getAttribute("ceid")||e.getAttribute("data-ceid")},CE2.IGNORE_HREF=/^\s*javascript:|^\s*#\s*$/,CE2.getName=function(e){var t,n;return(t=e.getAttribute("cename"))?t:(t=e.getAttribute("ceid"))?t:(t="SELECT"!=e.nodeName&&e.getAttribute("value"))?t:(t=e.getAttribute("title"))?t:(t=e.getAttribute("alt"))?t:(t=e.getAttribute("name"))?t:"A"==e.nodeName&&(t=CE2.innerTextName(e))?t:(t=CE2.href(e))&&(n=CE2.href(e))&&!CE2.IGNORE_HREF.test(n)?new CE2.URI(t).simplify():(t=e.getAttribute("src"))?new CE2.URI(t).simplify():(t=CE2.innerTextName(e))?t:(t=e.getAttribute("id"))?t:(t=CE2.formatClass(e))?t:""},CE2.getData=function(e){var t;switch(e.nodeName){case"A":if((t=CE2.href(e))&&!CE2.IGNORE_HREF.test(t))return new CE2.URI(e.href).simplify();if(e.className)return"@#"+CE2.formatClass(e);break;case"IMG":case"IFRAME":case"EMBED":return new CE2.URI(e.src).simplify();case"OBJECT":return new CE2.URI(e.data).simplify();case"INPUT":case"SELECT":case"TEXTAREA":return e.name;default:return CE2.formatClass(e)}},CE2.innerText=function(e){function t(e,t){var i,o;for(i=0;o=t[i++];)e=e.replace(o[n],"");return e}var n=void 0===e.textContent?"innerText":"textContent",i=e[n].substr(0,16384);return i=t(i,e.getElementsByTagName("SCRIPT")),i=t(i,e.getElementsByTagName("NOSCRIPT"))},CE2.innerTextName=function(e,t){var n=CE2.strip(CE2.strip(CE2.innerText(e),!0).substr(0,t||100));return CE2.strip(n.replace(/[\ud800-\udbff\udc00-\udfff]+$/,""))},CE2.tagTypes={a:3,abbr:4,acronym:5,address:6,applet:7,area:8,b:9,base:10,basefont:11,bdo:12,big:13,blockquote:14,body:15,br:16,button:17,caption:18,center:19,cite:20,code:21,col:22,colgroup:23,dd:24,del:25,dfn:26,dir:27,div:28,dl:29,dt:30,em:31,fieldset:32,font:33,form:34,frame:35,frameset:36,head:37,h1:38,h2:38,h3:38,h4:38,h5:38,h6:38,hr:38,html:39,i:40,iframe:41,img:42,input:43,ins:44,kbd:45,label:46,legend:47,li:48,link:49,map:50,menu:51,meta:52,noframes:53,noscript:54,object:55,embed:55,ol:56,optgroup:57,option:58,p:59,param:60,pre:61,q:62,s:63,samp:64,script:65,select:66,small:67,span:68,strike:69,strong:70,style:71,sub:72,sup:73,table:74,tbody:75,td:76,textarea:77,tfoot:78,th:79,thead:80,title:81,tr:82,tt:83,u:84,ul:85,var:86,article:87,aside:88,audio:89,bdi:90,canvas:91,command:92,details:93,figcaption:94,figure:95,footer:96,header:97,hgroup:98,keygen:99,mark:100,meter:101,nav:102,output:103,progress:104,rp:105,rt:106,ruby:107,section:108,summary:109,time:110,video:111,"(custom)":255},"undefined"==typeof CE2&&(CE2={}),CE2.URI.prototype.join=function(e){var t=new CE2.URI(this),n=this.path;return"string"==typeof e&&(e=new CE2.URI(e)),e.isURL()?new CE2.URI(e):(e.isAbsolute()?n=e.path:n?((n=n.split("/")).pop(),n=(n=e.path?n.concat(e.path.split("/")):n).join("/")):n=this.isURL()?"/"+e.path:e.path,t.path=n,t.qs=e.qs,t.hash=e.hash,t)},CE2.URI.prototype.normalize=function(){if(this.path){var e;CE2.ie&&CE2.ieVersion<9?(e=[],"/"==this.path.charAt(0)&&e.push(""),e=e.concat(this.path.split(/\/+/g)),"/"==this.path.charAt(this.path.length-1)&&e.push("")):e=this.path.split(/\/+/g);var t,n=0;do{if(t=e.length-1,".."==e[n+1])""==e[n]&&0==n?e.splice(n+1,1):(e.splice(n,2),n-=1);else if("."==e[n]){if(0==t)break;e.splice(n,1)}else n++}while(n<=t);this.path=e.join("/")}},CE2.URI.prototype.simplify=function(e){var t,n=[];if((t="file"==this.protocol?this:CE2.ie?e?e.join(this):this:(e=e||new CE2.URI(CE2.d.baseURI)).join(this)).normalize(),t.host&&n.push(t.host.replace(/^www\./,"")),null!=t.port&&n.push(":"+t.port),"/"==t.path||/^\/(default|home|index)\b[^\/]*$/i.test(t.path)?(t.qs||t.hash)&&n.push("/"):n.push(t.path),t.qs){var i=[];CE2.each(t.qs,function(e,t){e&&!/(^sess|^sid$|^phpsessid$|^jsessionid$|^__VIEWSTATE$)/i.test(t)&&i.push(encodeURIComponent(t)+"="+encodeURIComponent(e))}),i.length&&n.push("?"+i.join("&"))}return t.hash&&n.push("#"+t.hash),n.join("")},CE2.URI.prototype.sameOrigin=function(e){return!!e&&("string"==typeof e&&(e=new CE2.URI(e)),null==e.host||e.host==this.host&&e.port==this.port&&e.protocol==this.protocol)},CE2.Tracker=function(e,t,n){if(this.id=e,this.version=t,this.liveSessions=n,this.location=new CE2.URI(window.location.href),this.startTime=(new Date).getTime(),this.ignoredElements=CE2.ignoredElements.concat(CE2.findByClass("-ce-ignore")),this.clickCaptors=CE2.clickCaptors.concat(CE2.findByClass("-ce-capture")),this.trackURL="https:"==window.location.protocol?CE2.TRACKING_DEST_SECURE:CE2.TRACKING_DEST,this.liveURL="https:"==window.location.protocol?CE2.LIVE_DEST_SECURE:CE2.LIVE_DEST,this.opaqueElement=null,this.lastClicked=null,this.handlers={},CE2.each(["onOver","onOut","onBlur","onUnload","onClickFrame","onClick","foundAnchor"],function(e){this.handlers[e]=CE2.bind(this,e)},this),this.handleEvents(),this.isReturning=function(){var e=CE2.qs2obj(document.cookie.replace(/;\s*/g,"&"));if(e)return parseInt(e._ceir,10)||parseInt(e.is_returning,10)||0}(),"undefined"==typeof CE_NO_COOKIES||!CE_NO_COOKIES){var i,o=new Date;i="number"==typeof CE_COOKIE_EXPIRE_DAYS?new Date(o.getFullYear(),o.getMonth(),o.getDate()+CE_COOKIE_EXPIRE_DAYS).toUTCString():new Date(o.getFullYear()+5,o.getMonth(),o.getDate()).toUTCString(),document.cookie="_ceir=1;domain=."+this.location.host.replace(/^www\./,"")+";expires="+i}this.visit()},CE2.Tracker.prototype={handleEvents:function(){var e=this.handlers;(this.liveSessions||this.version&&this.version>=2)&&(CE2.initScrollTracking(),this.trackScrollInterval=setInterval(CE2.bind(this,"trackScroll"),100)),CE2.listen(document,"mousedown",e.onClick),CE2.each(["FRAME","IFRAME","OBJECT","EMBED"],function(t,n){var i,o,r=document.body.getElementsByTagName(t);for(n=0;i=r[n++];)/I?FRAME/.test(i.nodeName)&&this.location.sameOrigin(i.src)?CE2.listen(CE2.ieVersion<9?i.contentWindow.document:i.contentWindow,"mousedown",e.onClickFrame):(o=CE2.getBox(i)).width>1&&o.height>1&&(CE2.listen(i,"mouseover",e.onOver),CE2.listen(i,"mouseout",e.onOut))},this),CE2.listen(window,"blur",e.onBlur),CE2.listen(window,CE2.opera?"unload":"beforeunload",e.onUnload)},cleanup:function(){var e=this.handlers;clearInterval(this.trackScrollInterval),CE2.removeListener(document,"mousedown",e.onClick),CE2.removeListener(window,"blur",e.onBlur),CE2.removeListener(window,CE2.opera?"unload":"beforeunload",e.onUnload),CE2.each(["FRAME","IFRAME","OBJECT","EMBED"],function(t,n){var i,o,r=document.body.getElementsByTagName(t);for(n=0;i=r[n++];)/i?frame/i.test(i.nodeName)&&this.location.sameOrigin(i.src)?CE2.removeListener(CE2.ieVersion<9?i.contentWindow.document:i.contentWindow,"mousedown",e.onClickFrame):(o=CE2.getBox(i)).width>1&&o.height>1&&(CE2.removeListener(i,"mouseover",e.onOver),CE2.removeListener(i,"mouseout",e.onOut))},this)},ts:function(){return Math.floor((new Date).getTime()/1e3)},visit:function(){var e,t=this.liveSessions;if(t)for(e=0;t[e++];)this.send("v",0,this.ts())},click:function(e,t,n){var i,o,r,s,a,l,c,u,E;if(e!=document&&e!=document.body&&e!=document.documentElement&&!this.isIgnored(e)&&((E=CE2.arrayContains(this.clickCaptors,e))&&(e=E),"OPTION"==e.nodeName&&(e=e.parentNode),!CE2.isVML(e))){for(this.lastClicked=e,t&&(t.srcElement||t.target)&&(i=t),o=new CE2.Package(["type","i",1],["left","i",2],["top","i",2],["width","i",2],["height","i",2],["id","s",40],["ceid","s",40],["name","s",100],["data","s",180],["parentID","s",40],["x","i",1],["y","i",1],["windowWidth","i",1],["timeToClick","i",1],["isReturning","i",1],["referrer","s",100],["googleCampaignSource","s",100],["googleCampaignMedium","s",100],["googleCampaignTerm","s",100],["googleCampaignContent","s",100],["googleCampaignName","s",100],["user1","s",100],["user2","s",100],["user3","s",100],["user4","s",100],["user5","s",100],["flags","i",1]),1===e.nodeType?r=CE2.fingerprint(e):(o.set("type",CE2.tagTypes["(custom)"]),o.set("flags",1),CE2.getPageCoords(e),r=e),CE2.each(r,function(e,t){o.set(t,e)}),i?(t=(s=CE2.eventCoords(i))[0]-r.pageX,n=s[1]-r.pageY):null==t&&(t=r.width/2,n=r.height/2),o.set("x",Math.floor(255*t/r.width)),o.set("y",Math.floor(255*n/r.height)),0==(a=window.innerWidth?window.innerWidth:document.documentElement.clientWidth)?o.set("windowWidth",0):o.set("windowWidth",Math.floor(a/100)+1),o.set("timeToClick",CE2.getTimeRange((new Date).getTime()-this.startTime)),o.set("isReturning",this.isReturning),o.set("referrer",new CE2.URI(document.referrer).simplify()),(l=this.location.qs)&&(o.set("googleCampaignSource",l.utm_source||""),o.set("googleCampaignMedium",l.utm_medium||""),o.set("googleCampaignTerm",l.utm_term||""),o.set("googleCampaignContent",l.utm_content||""),o.set("googleCampaignName",l.utm_campaign||"")),u=1;u<=5;u++)(c=CE2.userData[u])&&o.set("user"+u,c);this.send("c",o)}},send:function(e,t,n){var i,o,r=this.liveSessions,s=t&&CE2.base64(""+t);if("v"!=e&&this.id&&(document.createElement("img").src=this.url(e,s,n)),r)for(i=0;o=r[i++];)document.createElement("img").src=this.url(e,s,n,o)},url:function(e,t,n,i){var o=i||this.id,t=t||"",n=n?n+(t&&"&"):"";return(i?this.liveURL:this.trackURL)+e+"?"+o+"&"+n+t},isIgnored:function(e){return CE2.arrayContains(this.ignoredElements,e)},onClick:function(e,t){var n,i;if(CE2.ieVersion&&(CE2.ieVersion<9||CE2.ieQuirksMode)){if(1!=e.button)return}else if(0!=e.button)return;i=t?(n=CE2.eventWindow(e)).frameElement:e.srcElement||e.target,t?this.click.apply(this,[i].concat(CE2.eventCoords(e,n))):this.click(i,e)},onClickFrame:function(e){this.onClick(e,!0)},onOver:function(e){var t=e.srcElement||e.target;this.isIgnored(t)||(this.opaqueElement=t)},onOut:function(e){this.isIgnored(e.srcElement||e.target)||(this.opaqueElement=null)},onBlur:function(e){var t=this.opaqueElement;t&&t!=this.lastClicked&&(this.click(t),this.opaqueElement=null)},onUnload:function(e){var t=this.opaqueElement;this.isIgnored(t)||t&&(this.click(t),this.opaqueElement=null)},trackScroll:function(){var e=CE2.scroll();CE2.shouldRecordScroll(e)&&CE2.findAnchor(e,this.handlers.foundAnchor)},foundAnchor:function(e,t){var n,i=new CE2.Package(["screenTop","i",2],["screenHeight","i",2],["screenTopDistanceFromAnchor","i",2],["screenBottomDistanceFromAnchor","i",2],["type","i",1],["left","i",2],["top","i",2],["width","i",2],["height","i",2],["id","s",40],["ceid","s",40],["name","s",100],["data","s",180],["parentID","s",40]);i.set("screenTop",e.top),i.set("screenHeight",e.height),t&&(n=CE2.fingerprint(t),i.set("screenTopDistanceFromAnchor",e.top-n.pageY+CE2.S16_0),i.set("screenBottomDistanceFromAnchor",e.top+e.height-n.pageY+CE2.S16_0),CE2.each(n,function(e,t){i.set(t,e)})),this.send("s",i,this.ts())}},CE2.tracker&&CE2.tracker.cleanup(),CE2.tracker=new CE2.Tracker(CE2.testID,CE2.testVersion,CE2.sessionIDs);