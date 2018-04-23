var DONT_ENUM = "propertyIsEnumerable,isPrototypeOf,hasOwnProperty,toLocaleString,toString,valueOf,constructor".split(","), hasOwn = ({}).hasOwnProperty;
for ( var i in {
	toString : 1
}) {
	DONT_ENUM = false;
}

Object.keys = Object.keys || function(obj) {// ecma262v5 15.2.3.14
	var result = [];
	for ( var key in obj)
		if (hasOwn.call(obj, key)) {
			result.push(key);
		}
	if (DONT_ENUM && obj) {
		for (var i = 0; key = DONT_ENUM[i++];) {
			if (hasOwn.call(obj, key)) {
				result.push(key);
			}
		}
	}
	return result;
};

//解决IE10以下不支持Function.bind
if (!Function.prototype.bind) {
    Function.prototype.bind = function(oThis) {
        if (typeof this !== "function") {
            throw new TypeError("Function.prototype.bind - what is trying to be bound is not callable");
        }
        var aArgs = Array.prototype.slice.call(arguments, 1),
            fToBind = this,
            fNOP = function() {},
            fBound = function() {
                return fToBind.apply(this instanceof fNOP && oThis ? this : oThis,
                    aArgs.concat(Array.prototype.slice.call(arguments)));
            };
        fNOP.prototype = this.prototype;
        fBound.prototype = new fNOP();
        return fBound;
    };
}

//解决IE8不支持map
if(!Array.prototype.map) {
	Array.prototype.map = function(callback, thisArg) {
		var T, A, k;
		if(this == null) {
			throw new TypeError("this is null or not defined");
		}
		var O = Object(this);
		var len = O.length >>> 0;
		if(typeof callback !== 'function') {
			throw new TypeError(callback + 'is not a function');
		}
		if(arguments.length > 1) {
			T = thisArg;
		}
		A = new Array(len);
		k = 0;
		while(k < len) {
			var kValue, mappedValue;
			if(k in O) {
				kValue = O[k];
				mappedValue = callback.call(T, kValue, k, O);
				A[k] = mappedValue;
			}
			k++;
		}
		return A;
	};
}

if(!Array.prototype.forEach) {
	Array.prototype.forEach = function(fun /*, thisp*/) {
		var len = this.length;
		if(typeof fun != 'function')
			throw new TypeError();
		var thisp = arguments[1];
		for(var i = 0; i < len; i++) {
			if (i in this)
				fun.call(thisp, this[i], i, this);
		}
	};
}
/*
Object.prototype.hasOwnProperty = function(name){
	if(typeof(this) == undefined) {
		return false;
	} else if(typeof(this) == 'function') {
		return false;
	} else {
		return true;
	}
};*/