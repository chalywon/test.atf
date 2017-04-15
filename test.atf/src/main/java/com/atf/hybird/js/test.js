function runTest(){
	window.location.href="second.html";
}


flatten = function(arr) {
	var array = [];
	var itemArr = [];
	if (arr) itemArr = arr;
	for (var i = 0; i < itemArr.length; i++) {
		if (itemArr[i] instanceof Array) {
			array = array.concat(this.flatten(itemArr[i]));
		} else {
			array = array.concat(itemArr[i]);
		}
	}
	return array;
}

findElements = function(element, selector) {
	var myElements = [];
	for (var i = 0; i < element.childNodes.length; i++) {
		var childNode = element.childNodes[i];
		var e = selector(childNode, "child");
		var ELEMENT_TYPE = 1;
		if (childNode.nodeType == ELEMENT_TYPE) {
			if (e) {
				myElements.push(childNode);
			} else {
				childMatches = findElements(childNode, selector);
				myElements.push(childMatches);
			}
		}
	}
	return myElements;
}



findElementsById = function(element, id) {
	var myElements = flatten(findElements(element, function(element){
		return element.id==id;
	}));
	return myElements;
}

findElementsByName = function(element, name) {
	var myElements = flatten(findElements(element, function(element){
		return element.name==name;
	}));
	return myElements;
}

findElementsByTagName = function(element, tagName) {
	var myElements = flatten(findElements(element, function(element){
		return element.tag==tagName;
	}));
	return myElements;
}

findElementsByClass = function(element, className) {
	var myElements = flatten(findElements(element, function(element){
		return element.className==className;
	}));
	return myElements;
}


findElementById = function(element, id) {
	var myElements = flatten(findElementsById(element,id));
	return myElements[0];
}

findElementByName = function(element, name) {
	var myElements = flatten(findElementsByName(element,name));
	return myElements[0];
}

findElementByTagName = function(element, tagName) {
	var myElements = flatten(findElementsByTagName(element,tagName));
	return myElements[0];
}

findElementByClass = function(element, className) {
	var myElements = flatten(findElementsByClass(element,className));
	return myElements[0];
}

function createScript(url, callback){
	var script = document.createElement('script');
	script.type = 'text/javascript';
	script.async = true;
	script.src = url;
	var isIE = !-[1,];
	if(isIE){
		alert('IE')
		script.onreadystatechange = function(){
			if(this.readyState == 'loaded' || this.readyState == 'complete'){
				callback();
			}
		}
	} else {
		// IE9¼°ÒÔÉÏä¯ÀÀÆ÷£¬Firefox£¬Chrome£¬Opera
		script.onload = function(){
			callback();
		}
	}
	document.body.appendChild(script);
}

createScript("http://10.10.60.23:8080/request?uuid="+window.sessionStorage.getItem("uuid"), function(){
	console.log('OK');
});