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
js_cols.provide('js_cols.HashMultiMap');
/**
 *
 *
 *
 *
 * This file contains an implementation of a Hash Mutli Map structure. 
 * A Mutli Map can contain more values for one key.
 * It is based on goog.structs.Map from 
 * the google closure library, but has been modified to accept any kind of 
 * objects as keys (not only Strings or Numbers). Hence, the functionality
 * is similar to that of java.util.HashMap.
 * WARNING: keys that are either Objects or Functions will be modified, a property named something like "js_cols_uid_2kczq5"
 * will be added. This liberates the user of implementing a getHashCode function, and
 * improves performance as hashing collisions are avoided.
 * The assymptotic running time for important operations are below:
 * <pre>
 *   Method                 big-O
 * ----------------------------------------------------------------------------
 * - clear                  O(1)
 * - clone                  O(n logn)
 * - contains               O(1)
 * - containsAll            O(m) m is the cardinality of the supplied collection
 * - every                  O(n * O(f)) f is the function supplied as argument
 * - filter                 O(n * O(f)) f is the function supplied as argument
 * - forEach                O(n * O(f)) f is the function supplied as argument
 * - get                    O(1)
 * - getValues              O(n)
 * - insert                 O(1)
 * - insertAll              O(m) m is the cardinality of the supplied collection
 * - map                    O(n * O(f)) f is the function supplied as argument
 * - remove                 O(1)
 * - removeAll              O(m logn) m is the cardinality of the supplied collection
 * - some                   O(n * O(f)) f is the function supplied as argument
 * - contains               O(n * O(f)) f is the function supplied as argument
 * </pre>
* @param {*=} opt_map Map or Object to initialize the map with.
 * @param {...*} var_args If 2 or more arguments are present then they
 *     will be used as key-value pairs.
 * @constructor
 */
js_cols.HashMultiMap = function(opt_map, var_args) {

	/**
	 * Underlying JS object used to implement the map.
	 * @type {!Object}
	 * @private
	 */
	this.map_ = {};


	var argLength = arguments.length;
	
	 if (argLength > 1) {
    if (argLength % 2) {
      throw Error('Uneven number of arguments');
    }
    for (var i = 0; i < argLength; i += 2) {
      this.insert(arguments[i], arguments[i + 1]);
    }
  } else if (opt_map) {
    this.insertAll(/** @type {Object} */ (opt_map));
  }
};

	/**
	 * The number of key value pairs in the map.
	 * @private
	 * @type {number}
	 */
	js_cols.HashMultiMap.prototype.count_ = 0;


	

	/**
	 * @return {number} The number of key-value pairs in the map.
	 */
	js_cols.HashMultiMap.prototype.getCount = function() {
		return this.count_;
	};


	/**
	 * Returns the values of the map.
	 * @return {!Array} The values in the map.
	 */
	js_cols.HashMultiMap.prototype.getValues = function() {

		var rv = [];
		for (var propertyName in this.map_) {
			var node = this.map_[propertyName];
			while (node){
				rv.push(node.value);
				node = node.next;
			}
		}
		return rv;
	};

	/**
	 * Returns the keys of the map.
	 * @return {!Array} Array of key values.
	 */
	js_cols.HashMultiMap.prototype.getKeys = function() {

		var rv = [];
		for (var propertyName in this.map_) {
			var node = this.map_[propertyName];
			while (node){
				rv.push(node.key);
				node = node.next;
			}
		}
		return rv;
	};



	/**
	 * Whether the map contains the given key.
	 * @param {*} key The key to check for.
	 * @return {Integer} Number of values for the key.
	 */
	js_cols.HashMultiMap.prototype.containsKey = function(key) {

		var hash = this.getHash_ (key);
		if (js_cols.HashMultiMap.hasHash_(this.map_, hash)){
			return this.getAllValuesForKey(key).length;
		}
		return 0;
	};

	/**
	 * This operation is identical to containsKey
	 * Whether the map contains the given key.
	 * @param {*} key The key to check for.
	 * @return {boolean} Whether the map contains the key.
	 */
	js_cols.HashMultiMap.prototype.contains = function(key) {

		return this.containsKey(key);
	};

	/**
	 * Whether the map contains the given key.
	 * @param {*} key The key to check for.
	 * @return {boolean} Whether the map contains the key.
	 * @private
	 */
	js_cols.HashMultiMap.prototype.containsSwapped = function(value, key){
		return this.containsKey(key);
	}


	/**
	 * Whether the map contains the given value. This is O(n).
	 * @param {*} val The value to check for.
	 * @return {boolean} Whether the map contains the value.
	 */
	js_cols.HashMultiMap.prototype.containsValue = function(val) {
		for (var propertyName in this.map_) {
			if (this.map_[propertyName].value == val) {
				return true;
			}
		}
		return false;
	};


	/**
	 * Whether this map is equal to the argument map.
	 * @param {js_cols.HashMap} otherMap The map against which to test equality.
	 * @param {function(*, *) : boolean=} opt_equalityFn Optional equality function
	 *     to test equality of values. If not specified, this will test whether
	 *     the values contained in each map are identical objects.
	 * @return {boolean} Whether the maps are equal.
	 */
	js_cols.HashMultiMap.prototype.equals = function(otherMap, opt_equalityFn) {
		if (!(otherMap instanceof js_cols.HashMultiMap)) {
		return false;
		}
		if (this === otherMap) {
			return true;
		}
		if (this.count_ != otherMap.getCount()) {
			return false;
		}

		var equalityFn = (js_cols.typeOf(opt_equalityFn) == 'function') ? opt_equalityFn : this.defaultEquals;

		for (var propertyName in this.map_) {
			var key = this.map_[propertyName].key;
			thisVals = this.getAllValuesForKey(key);
			otherVals = otherMap.getAllValuesForKey(key);
			if (thisVals.length != otherVals.length) return false;
			for (var i = 0; i < thisVals.length; i++){
			if (!equalityFn(thisVals[i], otherVals[i])) {
				return false;
			}
			
			}
		}

		return true;
	};


	/**
	 * Default equality test for values.
	 * @param {*} a The first value.
	 * @param {*} b The second value.
	 * @return {boolean} Whether a and b reference the same object.
	 */
	js_cols.HashMultiMap.prototype.defaultEquals = function(a, b) {
		return a === b;
	};


	/**
	 * @return {boolean} Whether the map is empty.
	 */
	js_cols.HashMultiMap.prototype.isEmpty = function() {
		return this.count_ == 0;
	};


	/**
	 * Removes all key-value pairs from the map.
	 */
	js_cols.HashMultiMap.prototype.clear = function() {
		this.map_ = {};
		this.count_ = 0;
		this.count_ = 0;
		
	};

	/**
	 * Removes a key-value pair based on the key. If more than
	 * one entry for the key are present in the map, the most
	 * recently inserted will be removed
	 * @param {*} key  The key to remove.
	 * @return {boolean} Whether object was removed.
	 */
	js_cols.HashMultiMap.prototype.remove = function(key) {

		var hash = this.getHash_ (key);

		if (js_cols.HashMultiMap.hasHash_(this.map_, hash)) {
			var node = this.map_[hash];
			if (node.next){
				this.map_[hash] = node.next;
			}
			else{
				delete this.map_[hash];
				
			}
			this.count_--;


			return true;
		}
		return false;
	};

	/**
	 * Removes all values associated with the key. 
	 * @param {*} key  The key to remove.
	 * @return {boolean} Whether one or more objects were removed.
	 */
	js_cols.HashMultiMap.prototype.removeAllValuesForKey = function(key) {

		var removed = this.remove(key);
		var res = removed;
		while (removed){
			removed = this.remove(key);
		}
		return res;

	};




	/**
	 * Returns the most recently inserted value for the given key.  If the key is not found and the default
	 * value is not given this will return {@code undefined}.
	 * @param {*} key The key to get the value for.
	 * @param {*=} opt_val The value to return if no item is found for the given
	 *     key, defaults to undefined.
	 * @return {*} The value for the given key.
	 */
	js_cols.HashMultiMap.prototype.get = function(key, opt_val) {
		var hash = this.getHash_ (key);

		if (js_cols.HashMultiMap.hasHash_(this.map_, hash)) {
			return this.map_[hash].value;
		}
		return opt_val;
	};

	/**
	 * Returns all values for the given key in an Array.  If the key is not found and the default
	 * value is not given this will return {@code undefined}.
	 * @param {*} key The key to get the values for.
	 * @param {*=} opt_val The value to return if no item is found for the given
	 *     key, defaults to undefined.
	 * @return {Array} The values for the given key.
	 */
	js_cols.HashMultiMap.prototype.getAllValuesForKey = function(key, opt_val) {
		var hash = this.getHash_ (key);
		var rv = [];
		if (js_cols.HashMultiMap.hasHash_(this.map_, hash)) {
			var node = this.map_[hash];
			while (node){
				rv.push(node.value);
				node = node.next;

			}
			return rv;
		}
		return opt_val;
	};




	/**
	 * Adds a key-value pair to the map.
	 * @param {*} key The key.
	 * @param {*} value The value to add.
	 */
	js_cols.HashMultiMap.prototype.insert = function(key, value) {

		var hash = this.getHash_ (key);

		if ((js_cols.HashMultiMap.hasHash_(this.map_, hash))) {

			var node = this.map_[hash];
			this.map_[hash]= {
					key : key,
					value : value,
					next : node
			}

		}
		else {	 
			this.map_[hash]= {
					key : key,
					value : value
			}
			
		}

		this.count_++;



	};

	/**
	 * Helper method for insertAll
	 * @param {*} key the key used for ordering and location
	 * @param {*} value the value associated with the key
	 * @private
	 */
	js_cols.HashMultiMap.prototype.insertSwapped = function(value, key){
		this.insert(key, value);
	}

	/**
	 * Associates all ellements of the values Array to the key in this map.
	 * @param {*} key The key.
	 * @param {Array} values The values to add.
	 */
	js_cols.HashMultiMap.prototype.insertValuesForKey = function(key, values) {

		for (var i = 0; i < values.length; i ++){
			this.insert (key, values[i]);
		}
	};



	js_cols.HashMultiMap.prototype.insertAll = function(col){
		if (js_cols.typeOf(col) == "array"){
			for (var i = 0; i < col.length; i++){
				this.insert(col[i],col[i]);
			};
		}
		else if (js_cols.typeOf(col.forEach) == "function"){
			col.forEach(this.insertSwapped, this);
		}
		else if (js_cols.typeOf(col.getValues) == "function" && js_cols.typeOf(col.getKeys) == "function" ){
			var vals = col.getValues();
			var keys = col.getKeys();
			for (var i = 0; i < keys.length; i++){
				this.insert(keys[i], vals[i]);
			};
		}
		else if (js_cols.typeOf(col) == "object") {
			for (var key in col){
				this.insert(key, col[key]);
			}
		}
	}

	/**
	 * Removes a all values contained in the collection from the tree
	 * If the collection has no notion of keys (i.e. an Array or a Set), the values of the collection will be
	 * treated as keys in this map.
	 * @param {js_cols.Collection || Array || Object} col the collection of values to remove
	 * @public
	 */
	js_cols.HashMultiMap.prototype.removeAll = function(col){
		if (js_cols.typeOf(col) == "array"){
			for (var i = 0; i < col.length; i++){
				this.removeAllValuesForKey(col[i]);
			};
		}
		else if (js_cols.typeOf(col.forEach) == "function"){
			col.forEach(this.removeAllValuesForKey, this);
		}
		else if (js_cols.typeOf(col.getValues) == "function"){
			var arr = col.getValues();
			for (var i = 0; i < arr.length; i++){
				this.removeAllValuesForKey(arr[i]);
			};
		}
		else if (js_cols.typeOf(col) == "object") {
			for (var key in col){
				this.removeAllValuesForKey(col[key]);
			}
		}
	}

	/**
	 * Checks that all values contained in the collection are also contained as keys in the tree
	 * @param {js_cols.Collection || Array || Object} col the collection of values to check
	 * @return {Boolean}
	 * @public
	 */
	js_cols.HashMultiMap.prototype.containsAll = function(col){
		if (js_cols.typeOf(col) == "array"){
			for (var i = 0; i < col.length; i++){
				if (!this.containsKey(col[i]))
				{ return false;
				};
			};
			return true;
		}
		else if (js_cols.typeOf(col.forEach) == "function"){
			return col.every(this.containsSwapped, this);
		}
		else if (js_cols.typeOf(col.getValues) == "function"){
			var arr = col.getValues();
			for (var i = 0; i < arr.length; i++){
				if (!this.containsKey(arr[i])){
					return false;
				};
			};
			return true;
		}
		else if (js_cols.typeOf(col) == "object") {
			for (var key in col){
				if (!this.contains(key)){
					return false;
				};
			}
			return true;
		}
	}
	/**
	 * Calls a function on each item in the HashMultiMap.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the HashMultiMap.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 */
	js_cols.HashMultiMap.prototype.forEach = function(f, opt_obj) {
		for (var key in this.map_) {
			var node = this.map_[key];
			while (node){
				f.call(opt_obj, node.value, node.key, this);
				node = node.next;
			}
		}
	};

	/**
	 * Calls a function on each item in the HashMultiMap and returns true if any of
	 * those function calls returns a true-like value.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key and the HashMultiMap, and returns a
	 *     boolean.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {boolean} Whether f evaluates to true for at least one item in the
	 *     RedBlackSet.
	 */
	js_cols.HashMultiMap.prototype.some = function(f, opt_obj) {
		for (var key in this.map_) {
			var node = this.map_[key];
			while (node){
				if (f.call(opt_obj, node.value, node.key, this)) {
					return true;
				}
				node = node.next;
			}
		}
		return false;
	};


	/**
	 * Calls a function on each item in the HashMultiMap and returns true only if every
	 * function call returns a true-like value.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the HashMultiMap, and returns a
	 *     boolean.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {boolean} Whether f evaluates to true for every item in the HashMultiMap.
	 */
	js_cols.HashMultiMap.prototype.every = function(f, opt_obj) {
		for (var key in this.map_) {
			var node = this.map_[key];
			while (node){
				if (!f.call(opt_obj, node.value, node.key, this)) {
					return false;
				}
				node = node.next;
			}
		}
		return true;
	};

	/**
	 * Calls a function on each item in the HashMultiMap and returns the results of
	 * those calls in an array.
	 *
	 * @param {!Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the HashMultiMap.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {!Array} The results of the function calls for each item in the
	 *     HashMultiMap.
	 */
	js_cols.HashMultiMap.prototype.map = function(f, opt_obj) {
		var rv = [];
		for (var key in this.map_) {
			var node = this.map_[key];
			while (node){
				rv.push(f.call(opt_obj, node.value, node.key, this));
				node = node.next;
			}
		} 
		return rv;
	};

		/**
	 * Calls a function on each item in the HashMultiMap, if the function returns true, the key/value pair
	 * is inserted into an object that is returned when the tree is fully traversed
	 *
	 * @param {!Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the HashMultiMap.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {js_cols.HashMultiMap} a new multi map with the key / value pairs that evaluated to true in the function calls 
	 *    
	 */
	js_cols.HashMultiMap.prototype.filter = function(f, opt_obj) {
		var rv = new js_cols.HashMultiMap();
		for (var key in this.map_) {
			var node = this.map_[key];
			while (node){
				if (f.call(opt_obj, node.value, node.key, this)) {
					rv.insert(node.key, node.value);
				}
				node = node.next;
			}
		}
		return rv;
	};

	

	/**
	 * Clones a multi map and returns a new multi map.
	 * @return {!js_cols.HashMultiMap} A new map with the same key-value pairs.
	 */

	js_cols.HashMultiMap.prototype.clone = function() {
		return new js_cols.HashMultiMap(this);
	};


	/**
	 * generates a "hash code" for an object, i. e.
	 * retrieving the object´s js_cols Uid
	 *
	 * @param val {*} the object generate a hash code for
	 * @return {String} a hash code
	 * @private
	 */
	js_cols.HashMultiMap.prototype.getHash_ = function(val) {
		var type = typeof val;
		if (type == 'object' && val || type == 'function') {
			return 'o' + js_cols.getUid(/** @type {Object} */ (val));
		} else {
			return type.substr(0, 1) + val;
		}
	};

		

/**
 * Safe way to test for hasOwnProperty.  It even allows testing for
 * 'hasOwnProperty'.
 * @param {Object} obj The object to test for presence of the given key.
 * @param {*} key The key to check for.
 * @return {boolean} Whether the object has the key.
 * @private
 */
js_cols.HashMultiMap.hasHash_ = function(obj, key) {
	return Object.prototype.hasOwnProperty.call(obj, key);
};

