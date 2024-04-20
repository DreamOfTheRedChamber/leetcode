//Copyright 2010 Thomas Stjernegaard Jeppesen. All Rights Reserved.

//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at

//http://www.apache.org/licenses/LICENSE-2.0

//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS-IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.



/**
 * @fileoverview Bootstrap for the js_cols Library.
 * The code in this file, base.js, is adopted partly from googles base.js,
 * and partly from structs.js.
 * It has been modified to suit the needs of the js_cols Library.
 * The js_cols collections should be easily integratable in projets
 * using google closure library, as they generally use the same method names,
 * code style and use of closures.
 *
 */

/**
 * Declaring a global js_cols variable
 */
js_cols = {};


/**
 * Reference to the global context.  In most cases this will be 'window'.
 */
js_cols.global = this;


/**
 * Implements a system for the dynamic resolution of dependencies
 * @param {string} rule Rule to include, in the form js_cols.part.
 */
js_cols.require = function(rule) {


    if (js_cols.getObjectByName(rule)) {
      return;
    }
    var path = js_cols.getPathFromDeps_(rule);
    if (path) {
      js_cols.included_[path] = true;
      js_cols.writeScripts_();
    } else {
      var errorMessage = 'js_cols.require could not find: ' + rule;
      
        throw Error(errorMessage);
    }
  
};

/**
 * Creates object stubs for a namespace. When present in a file, goog.provide
 * also indicates that the file defines the indicated object. 
 * @param {string} name name of the object that this file defines.
 */
js_cols.provide = function(name) {
 
    // Ensure that the same namespace isn't provided twice. 
    if (js_cols.getObjectByName(name) && !js_cols.implicitNamespaces_[name]) {
      throw Error('Namespace "' + name + '" already declared.');
    }

    var namespace = name;
    while ((namespace = namespace.substring(0, namespace.lastIndexOf('.')))) {
      js_cols.implicitNamespaces_[namespace] = true;
    }
 

  js_cols.exportPath_(name);
};

js_cols.implicitNamespaces_ = {};
/**
 * Path for included scripts
 * @type {string}
 */
js_cols.basePath = '';

/**
   * Tries to detect whether is in the context of an HTML document.
   * @return {boolean} True if it looks like HTML document.
   * @private
   */
  js_cols.inHtmlDocument_ = function() {
    var doc = js_cols.global.document;
    return typeof doc != 'undefined' &&
           'write' in doc;  // XULDocument misses write.
  }; 
  
  
  /**
 * Builds an object structure for the provided namespace path,
 * ensuring that names that already exist are not overwritten. For
 * example:
 * "a.b.c" -> a = {};a.b={};a.b.c={};
 * Used by goog.provide and goog.exportSymbol.
 * @param {string} name name of the object that this file defines.
 * @param {*=} opt_object the object to expose at the end of the path.
 * @param {Object=} opt_objectToExportTo The object to add the path to; default
 *     is |js_cols.global|.
 * @private
 */
js_cols.exportPath_ = function(name, opt_object, opt_objectToExportTo) {
  var parts = name.split('.');
  var cur = opt_objectToExportTo || js_cols.global;

  // Internet Explorer exhibits strange behavior when throwing errors from
  // methods externed in this manner.  See the testExportSymbolExceptions in
  // base_test.html for an example.
  if (!(parts[0] in cur) && cur.execScript) {
    cur.execScript('var ' + parts[0]);
  }

  // Certain browsers cannot parse code in the form for((a in b); c;);
  // This pattern is produced by the JSCompiler when it collapses the
  // statement above into the conditional loop below. To prevent this from
  // happening, use a for-loop and reserve the init logic as below.

  // Parentheses added to eliminate strict JS warning in Firefox.
  for (var part; parts.length && (part = parts.shift());) {
    if (!parts.length && opt_object !== undefined) {
      // last part and we have an object; use it
      cur[part] = opt_object;
    } else if (cur[part]) {
      cur = cur[part];
    } else {
      cur = cur[part] = {};
    }
  }
};

/**
 * Returns an object based on its fully qualified external name.  If you are
 * using a compilation pass that renames property names beware that using this
 * function will not find renamed properties.
 *
 * @param {string} name The fully qualified name.
 * @param {Object=} opt_obj The object within which to look; default is
 *     |goog.global|.
 * @return {Object} The object or, if not found, null.
 */
js_cols.getObjectByName = function(name, opt_obj) {
  var parts = name.split('.');
  var cur = opt_obj || js_cols.global;
  for (var part; part = parts.shift(); ) {
    if (cur[part]) {
      cur = cur[part];
    } else {
      return null;
    }
  }
  return cur;
};

 js_cols.included_ = {};
  /**
   * This object is used to keep track of dependencies and other data that is
   * used for loading scripts
   * @private
   * @type {Object}
   */
  js_cols.dependencies_ = {
    pathToNames: {}, // 1 to many
    nameToPath: {}, // 1 to 1
    requires: {}, // 1 to many
    // used when resolving dependencies to prevent us from
    // visiting the file twice
    visited: {},
    written: {} // used to keep track of script files we have written
  };
  
  /**
 * Adds a dependency from a file to the files it requires.
 * @param {string} relPath The path to the js file.
 * @param {Array} provides An array of strings with the names of the objects
 *                         this file provides.
 * @param {Array} requires An array of strings with the names of the objects
 *                         this file requires.
 */
js_cols.addDependency = function(relPath, provides, requires) {

    var provide, require;
    var path = relPath.replace(/\\/g, '/');
    var deps = js_cols.dependencies_;
    for (var i = 0; provide = provides[i]; i++) {
      deps.nameToPath[provide] = path;
      if (!(path in deps.pathToNames)) {
        deps.pathToNames[path] = {};
      }
      deps.pathToNames[path][provide] = true;
    }
    for (var j = 0; require = requires[j]; j++) {
      if (!(path in deps.requires)) {
        deps.requires[path] = {};
      }
      deps.requires[path][require] = true;
    }
  
};

/**
   * Resolves dependencies based on the dependencies added using addDependency
   * and calls importScript_ in the correct order.
   * @private
   */
  js_cols.writeScripts_ = function() {
    // the scripts we need to write this time
    var scripts = [];
    var seenScript = {};
    var deps = js_cols.dependencies_;

    function visitNode(path) {
      if (path in deps.written) {
        return;
      }

      // we have already visited this one. We can get here if we have cyclic
      // dependencies
      if (path in deps.visited) {
        if (!(path in seenScript)) {
          seenScript[path] = true;
          scripts.push(path);
        }
        return;
      }

      deps.visited[path] = true;

      if (path in deps.requires) {
        for (var requireName in deps.requires[path]) {
          if (requireName in deps.nameToPath) {
            visitNode(deps.nameToPath[requireName]);
          } else if (!js_cols.getObjectByName(requireName)) {
            // If the required name is defined, we assume that this
            // dependency was bootstapped by other means. Otherwise,
            // throw an exception.
            throw Error('Undefined nameToPath for ' + requireName);
          }
        }
      }

      if (!(path in seenScript)) {
        seenScript[path] = true;
        scripts.push(path);
      }
    }

    for (var path in js_cols.included_) {
      if (!deps.written[path]) {
        visitNode(path);
      }
    }

    for (var i = 0; i < scripts.length; i++) {
      if (scripts[i]) {
        js_cols.importScript_(js_cols.basePath + scripts[i]);
      } else {
        throw Error('Undefined script input');
      }
    }
  };

 /**
   * Imports a script if, and only if, that script hasn't already been imported.
   * (Must be called at execution time)
   * @param {string} src Script source.
   * @private
   */
  js_cols.importScript_ = function(src) {
    var importScript =  js_cols.writeScriptTag_;
    if (!js_cols.dependencies_.written[src] && importScript(src)) {
      js_cols.dependencies_.written[src] = true;
    }
  };
  
   /**
   * The default implementation of the import function. Writes a script tag to
   * import the script.
   *
   * @param {string} src The script source.
   * @return {boolean} True if the script was imported, false otherwise.
   * @private
   */
  js_cols.writeScriptTag_ = function(src) {
    if (js_cols.inHtmlDocument_()) {
      var doc = js_cols.global.document;
      doc.write(
          '<script type="text/javascript" src="' + src + '"></' + 'script>');
      return true;
    } else {
      return false;
    }
  };
/**
   * Looks at the dependency rules and tries to determine the script file that
   * fulfills a particular rule.
   * @param {string} rule In the form js_cols.Class or project.script.
   * @return {?string} Url corresponding to the rule, or null.
   * @private
   */
 js_cols.getPathFromDeps_ = function(rule) {
    if (rule in js_cols.dependencies_.nameToPath) {
      return js_cols.dependencies_.nameToPath[rule];
    } else {
      return null;
    }
  };
  
  /**
 * Gets a unique ID for an object. This mutates the object so that further
 * calls with the same object as a parameter returns the same value. The unique
 * ID is guaranteed to be unique across the current session amongst objects that
 * are passed into {@code getUid}. There is no guarantee that the ID is unique
 * or consistent across sessions. It is unsafe to generate unique ID for
 * function prototypes.
 *
 * @param {Object} obj The object to get the unique ID for.
 * @return {number} The unique ID for the object.
 * @public
 */
js_cols.getUid = function(obj) {
  // TODO(user): Make the type stricter, do not accept null.

  // In Opera window.hasOwnProperty exists but always returns false so we avoid
  // using it. As a consequence the unique ID generated for BaseClass.prototype
  // and SubClass.prototype will be the same.
  return obj[js_cols.UID_PROPERTY_] ||
      (obj[js_cols.UID_PROPERTY_] = ++js_cols.uidCounter_);
};

/**
 * Removes the unique ID from an object. This is useful if the object was
 * previously mutated using {@code js_cols.getUid} in which case the mutation is
 * undone.
 * @param {Object} obj The object to remove the unique ID field from.
 * @public
 */
js_cols.removeUid = function(obj) {
  // TODO(user): Make the type stricter, do not accept null.

  // DOM nodes in IE are not instance of Object and throws exception
  // for delete. Instead we try to use removeAttribute
  if ('removeAttribute' in obj) {
    obj.removeAttribute(js_cols.UID_PROPERTY_);
  }
  /** @preserveTry */
  try {
    delete obj[js_cols.UID_PROPERTY_];
  } catch (ex) {
  }
};


/**
 * Name for unique ID property. Initialized in a way to help avoid collisions
 * with other closure javascript on the same page.
 * @type {string}
 * @private
 */

 
js_cols.UID_PROPERTY_ = 'js_cols_uid_' +
    Math.floor(Math.random() * 2147483648).toString(36);


/**
 * Counter for UID.
 * @type {number}
 * @private
 */
js_cols.uidCounter_ = 0;

/**
 * Returns the values of the object/map/hash.
 *
 * @param {Object} obj The object from which to get the values.
 * @return {!Array} The values in the object/map/hash.
 * @public
 */
js_cols.getValues = function(obj) {

	if (js_cols.typeOf(obj) == 'array'){
		return obj;
	}
	else if(!obj.getValues){
    var res = [];
    var i = 0;
    for (var key in obj) {
    res[i++] = obj[key];
   }
  }
  else{
   var res = obj.getValues();
  }
  return res;
};


/**
 * Returns the keys of the object/map/hash.
 *
 * @param {Object} obj The object from which to get the keys.
 * @return {!Array.<string>} Array of property keys.
 * @public
 */
js_cols.getKeys = function(obj) {

	if (obj.getKeys){
		return obj.getKeys();
		}
	else if (js_cols.typeOf(obj) == 'array'){
		var res = [];
			for (var i = 0; i < obj.length; i++){
			res.push(i);
			}
		return res;
		}
	else if (js_cols.typeOf(obj) == 'object'){
  		var res = [];
 		 var i = 0;
 		 for (var key in obj) {
   			 res[i++] = key;
  			}
  		return res;
  		}
  
};

/**
 * Calls a function for each element in an object/map/hash. If
 * all calls return true, returns true. If any call returns false, returns
 * false at this point and does not continue to check the remaining elements.
 *
 * @param {Object} obj The object to check.
 * @param {Function} f The function to call for every element. This function
 *     takes 3 arguments (the element, the index and the object) and should
 *     return a boolean.
 * @param {Object=} opt_obj This is used as the 'this' object within f.
 * @return {boolean} false if any element fails the test.
 * @public
 */


js_cols.every = function(obj, f, opt_obj) {

		if (js_cols.typeOf(obj.every) == 'function'){
			return obj.every(f, opt_obj);
		}
else	if (js_cols.typeOf(obj.getValues) == 'function'){
		var col = obj.getValues();
  		for (var i =0; i< col.length; i++ ) {
    		if (!f.call(opt_obj, col[i], i, col)) {
      			return false;
    			}
    		}
    		return true;
 		 }
 else	if (js_cols.typeOf(obj) == 'array'){
 		for (var i =0; i< obj.length; i++ ) {
    		if (!f.call(opt_obj, obj[i], i, obj)) {
      			return false;
    			}
    		}
    		return true;
 		}
else 	if (js_cols.typeOf(obj) == 'object'){
 		for (var key in obj) {
   			 if (!f.call(opt_obj, obj[key], key, obj)) {
      			return false;
    		}
 		}
 		return true;
 	}
 
};

/**
 * Calls a function for each element in an object/map/hash. 
 * @param {Object} obj The object to traverse.
 * @param {Function} f The function to call for every element. This function
 *     takes 3 arguments (the element, the index and the object) 
 * @param {Object=} opt_obj This is used as the 'this' object within f.
 * @public
 */


js_cols.forEach = function(obj, f, opt_obj) {

		if (js_cols.typeOf(obj.forEach) == 'function'){
			obj.forEach(f, opt_obj);
		}
else	if (js_cols.typeOf(obj.getValues) == 'function'){
		var col = obj.getValues();
  		for (var i =0; i< col.length; i++ ) {
    		f.call(opt_obj, col[i], i, col)
 		 }
 		 }
 else	if (js_cols.typeOf(obj) == 'array'){
 		for (var i =0; i< obj.length; i++ ) {
    		f.call(opt_obj, obj[i], i, obj)
 		}
 		}
else 	if (js_cols.typeOf(obj) == 'object'){
 		for (var key in obj) {
   			f.call(opt_obj, obj[key], key, obj)
 	}
 	}
 
};

/**
 * Returns the number of values in the collection-like object.
 * @param {Object} col The collection-like object.
 * @return {number} The number of values in the collection-like object.
 * @public
 */
js_cols.getCount = function(col) {
  if (typeof col.getCount == 'function') {
    return col.getCount();
  }
 else if (col.length && typeof col.length == "number") {
    return col.length;
  }
  else{
  var rv = 0;
  for (var key in col) {
    rv++;
  }
  return rv;
  }
};


/**
 * Whether the collection contains the given value. This is O(n) and uses
 * equals (==) to test the existence.
 * @param {Object} col The collection-like object.
 * @param {*} val The value to check for.
 * @return {boolean} True if the map contains the value.
 * @public
 */
js_cols.contains = function(col, val) {
  if (typeof col.contains == 'function') {
    return col.contains(val);
  }
  if (typeof col.containsValue == 'function') {
    return col.containsValue(val);
  }
  if (js_cols.typeOf(col) == 'array') {
    for (var i=0; i<col.length;i++){
    	if (col[i] == val) return true;
    }
    return false;
  }
   for (var key in col) {
    if (col[key] == val) {
      return true;
    }
  }
  return false;
};



/**
 * This is a "fixed" version of the typeof operator.  It differs from the typeof
 * operator in such a way that null returns 'null' and arrays return 'array'.
 * @param {*} value The value to get the type of.
 * @return {string} The name of the type.
 * @public
 */
js_cols.typeOf = function(value) {
  var s = typeof value;
  if (s == 'object') {
    if (value) {
      // We cannot use constructor == Array or instanceof Array because
      // different frames have different Array objects. In IE6, if the iframe
      // where the array was created is destroyed, the array loses its
      // prototype. Then dereferencing val.splice here throws an exception, so
      // we can't use goog.isFunction. Calling typeof directly returns 'unknown'
      // so that will work. In this case, this function will return false and
      // most array functions will still work because the array is still
      // array-like (supports length and []) even though it has lost its
      // prototype.
      // Mark Miller noticed that Object.prototype.toString
      // allows access to the unforgeable [[Class]] property.
      //  15.2.4.2 Object.prototype.toString ( )
      //  When the toString method is called, the following steps are taken:
      //      1. Get the [[Class]] property of this object.
      //      2. Compute a string value by concatenating the three strings
      //         "[object ", Result(1), and "]".
      //      3. Return Result(2).
      // and this behavior survives the destruction of the execution context.
      if (value instanceof Array ||  // Works quickly in same execution context.
          // If value is from a different execution context then
          // !(value instanceof Object), which lets us early out in the common
          // case when value is from the same context but not an array.
          // The {if (value)} check above means we don't have to worry about
          // undefined behavior of Object.prototype.toString on null/undefined.
          //
          // HACK: In order to use an Object prototype method on the arbitrary
          //   value, the compiler requires the value be cast to type Object,
          //   even though the ECMA spec explicitly allows it.
          (!(value instanceof Object) &&
           (Object.prototype.toString.call(
               /** @type {Object} */ (value)) == '[object Array]') ||

           // In IE all non value types are wrapped as objects across window
           // boundaries (not iframe though) so we have to do object detection
           // for this edge case
           typeof value.length == 'number' &&
           typeof value.splice != 'undefined' &&
           typeof value.propertyIsEnumerable != 'undefined' &&
           !value.propertyIsEnumerable('splice')

          )) {
        return 'array';
      }
      // HACK: There is still an array case that fails.
      //     function ArrayImpostor() {}
      //     ArrayImpostor.prototype = [];
      //     var impostor = new ArrayImpostor;
      // this can be fixed by getting rid of the fast path
      // (value instanceof Array) and solely relying on
      // (value && Object.prototype.toString.vall(value) === '[object Array]')
      // but that would require many more function calls and is not warranted
      // unless closure code is receiving objects from untrusted sources.

      // IE in cross-window calls does not correctly marshal the function type
      // (it appears just as an object) so we cannot use just typeof val ==
      // 'function'. However, if the object has a call property, it is a
      // function.
      if (!(value instanceof Object) &&
          (Object.prototype.toString.call(
              /** @type {Object} */ (value)) == '[object Function]' ||
          typeof value.call != 'undefined' &&
          typeof value.propertyIsEnumerable != 'undefined' &&
          !value.propertyIsEnumerable('call'))) {
        return 'function';
      }


    } else {
      return 'null';
    }

  } else if (s == 'function' && typeof value.call == 'undefined') {
    // In Safari typeof nodeList returns 'function', and on Firefox
    // typeof behaves similarly for HTML{Applet,Embed,Object}Elements
    // and RegExps.  We would like to return object for those and we can
    // detect an invalid function by making sure that the function
    // object has a call method.
    return 'object';
  }
  return s;
};

/**
 * Inherit the prototype methods from one constructor into another.
 *
 * Usage:
 * <pre>
 * function ParentClass(a, b) { }
 * ParentClass.prototype.foo = function(a) { }
 *
 * function ChildClass(a, b, c) {
 *   ParentClass.call(this, a, b);
 * }
 *
 * js_cols.inherits(ChildClass, ParentClass);
 *
 * var child = new ChildClass('a', 'b', 'see');
 * child.foo(); // works
 * </pre>
 *
 * In addition, a superclass' implementation of a method can be invoked
 * as follows:
 *
 * <pre>
 * ChildClass.prototype.foo = function(a) {
 *   ChildClass.superClass_.foo.call(this, a);
 *   // other code
 * };
 * </pre>
 *
 * @param {Function} childCtor Child class.
 * @param {Function} parentCtor Parent class.
 */
js_cols.inherits = function(childCtor, parentCtor) {
  /** @constructor */
  function tempCtor() {};
  tempCtor.prototype = parentCtor.prototype;
  childCtor.superClass_ = parentCtor.prototype;
  childCtor.prototype = new tempCtor();
  childCtor.prototype.constructor = childCtor;
};




js_cols.addDependency("js_cols/ABItem.js", ['js_cols.ABItem'], []);
js_cols.addDependency("js_cols/ABTreeBag.js", ['js_cols.ABTreeBag'], ['js_cols.ABTreeSet']);
js_cols.addDependency("js_cols/ABTreeMap.js", ['js_cols.ABTreeMap'], ['js_cols.LinkedList', 'js_cols.ABItem']);
js_cols.addDependency("js_cols/ABTreeMultiMap.js", ['js_cols.ABTreeMultiMap'], ['js_cols.ABTreeMap']);
js_cols.addDependency("js_cols/ABTreeSet.js", ['js_cols.ABTreeSet'], ['js_cols.LinkedList', 'js_cols.ABItem']);
js_cols.addDependency("js_cols/HashBag.js", ['js_cols.HashBag'], ['js_cols.HashMultiMap']);
js_cols.addDependency("js_cols/HashMap.js", ['js_cols.HashMap'], []);
js_cols.addDependency("js_cols/HashMultiMap.js", ['js_cols.HashMultiMap'], []);
js_cols.addDependency("js_cols/HashSet.js", ['js_cols.HashSet'], ['js_cols.HashMap']);
js_cols.addDependency("js_cols/IntervalHeap.js", ['js_cols.IntervalHeap'], []);
js_cols.addDependency("js_cols/LinkedHashMap.js", ['js_cols.LinkedHashMap'], ['js_cols.LinkedList', 'js_cols.HashMap']);
js_cols.addDependency("js_cols/LinkedList.js", ['js_cols.LinkedList'], []);
js_cols.addDependency("js_cols/Queue.js", ['js_cols.Queue'], ['js_cols.LinkedList']);
js_cols.addDependency("js_cols/RBnode.js", ['js_cols.RBnode'], []);
js_cols.addDependency("js_cols/RedBlackBag.js", ['js_cols.RedBlackBag'], ['js_cols.RedBlackSet', 'js_cols.RBnode']);
js_cols.addDependency("js_cols/RedBlackMap.js", ['js_cols.RedBlackMap'], ['js_cols.RBnode']);
js_cols.addDependency("js_cols/RedBlackMultiMap.js", ['js_cols.RedBlackMultiMap'], ['js_cols.RedBlackMap']);
js_cols.addDependency("js_cols/RedBlackSet.js", ['js_cols.RedBlackSet'], ['js_cols.RBnode']);
js_cols.addDependency("js_cols/Stack.js", ['js_cols.Stack'], ['js_cols.LinkedList']);

