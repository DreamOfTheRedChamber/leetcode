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
js_cols.provide('js_cols.HashMap');
/**
 *
 *
 *
 *
 * This file contains an implementation of a Hash Map structure. 
 * It is based on goog.structs.Map from 
 * the google closure library, but has been modified to accept any kind of 
 * objects as keys (not only Strings or Numbers). Hence, the functionality
 * is similar to that of java.util.HashMap.
 * WARNING: keys will be modified, a property named something like "js_cols_uid_2kczq5"
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
js_cols.HashMap = function(opt_map, var_args) {

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
	js_cols.HashMap.prototype.count_ = 0;


	/**
	 * Version used to detect changes while iterating.
	 * @private
	 * @type {number}
	 */
	js_cols.HashMap.prototype.version_ = 0;

	/**
	 * @return {number} The number of key-value pairs in the map.
	 */
	js_cols.HashMap.prototype.getCount = function() {
		return this.count_;
	};


	/**
	 * Returns the values of the map.
	 * @return {!Array} The values in the map.
	 */
	js_cols.HashMap.prototype.getValues = function() {


		var rv = [];
		for (var propertyName in this.map_) {

			rv.push(this.map_[propertyName].value);
		}
		return rv;
	};

	/**
	 * Returns the keys of the map.
	 * @return {!Array} Array of key contained in this map.
	 */
	js_cols.HashMap.prototype.getKeys = function() {


		var rv = [];
		for (var propertyName in this.map_) {

			rv.push(this.map_[propertyName].key);
		}
		return rv;
	};



	/**
	 * Whether the map contains the given key.
	 * @param {*} key The key to check for.
	 * @return {boolean} Whether the map contains the key.
	 */
	js_cols.HashMap.prototype.containsKey = function(key) {

		var hash = this.getHash_(key);
		return js_cols.HashMap.hasHash_(this.map_, hash);
	};

	/**
	 * This operation is identical to containsKey.
	 * Whether the map contains the given key.
	 * @param {*} key The key to check for.
	 * @return {boolean} Whether the map contains the key.
	 */
	js_cols.HashMap.prototype.contains = function(key) {

		return this.containsKey(key);
	};

	/**
	 * Whether the map contains the given key.
	 * @param {*} key The key to check for.
	 * @return {boolean} Whether the map contains the key.
	 * @private
	 */
	js_cols.HashMap.prototype.containsSwapped = function(value, key){
		return this.containsKey(key);
	}

	/**
	 * Whether the map contains the given value. This is O(n).
	 * @param {*} val The value to check for.
	 * @return {boolean} Whether the map contains the value.
	 */
	js_cols.HashMap.prototype.containsValue = function(val) {
		for (var propertyName in this.map_) {
			if (this.map_[propertyName].value == val) {
				return true;
			}
		}
		return false;
	};


	/**
	 * Default equality test for values.
	 * @param {*} a The first value.
	 * @param {*} b The second value.
	 * @return {boolean} Whether a and b reference the same object.
	 */
	js_cols.HashMap.prototype.defaultEquals = function(a, b) {
		return a === b;
	};
	
	/**
	 * Whether this map is equal to the argument map.
	 * @param {js_cols.HashMap} otherMap The map against which to test equality.
	  * @param {Function=} opt_equalityFn Optional comparison function.
 *     Should take 2 arguments to compare, and return true if the arguments
 *     are equal. Defaults to {@link js_cols.HashMap.defaultEquals} which
 *     compares the elements using the built-in '===' operator.
	 * @return {boolean} Whether the maps are equal.
	 */
	js_cols.HashMap.prototype.equals = function(otherMap, opt_equalityFn) {
		if (!(otherMap instanceof js_cols.HashMap)) {
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
			if (!equalityFn(this.get(key), otherMap.get(key))) {
				return false;
			}
		}

		return true;
	};


	/**
	 * @return {boolean} Whether the map is empty.
	 */
	js_cols.HashMap.prototype.isEmpty = function() {
		return this.count_ == 0;
	};


	/**
	 * Removes all key-value pairs from the map.
	 */
	js_cols.HashMap.prototype.clear = function() {
		this.map_ = {};
		this.count_ = 0;
		this.count_ = 0;
		this.version_ = 0;
	};

	/**
	 * Removes a key-value pair based on the key. This is O(logN) amortized due to
	 * updating the keys array whenever the count becomes half the size of the keys
	 * in the keys array.
	 * @param {*} key  The key to remove.
	 * @return {boolean} Whether object was removed.
	 */
	js_cols.HashMap.prototype.remove = function(key) {

		var hash = this.getHash_ (key);

		if (js_cols.HashMap.hasHash_(this.map_, hash)) {
			delete this.map_[hash];
			this.count_--;
			this.version_++;

			return true;
		}
		return false;
	};

	/**
	 * Helper method for removeAll
	 * @param {*} key the key used for ordering and location
	 * @param {*} element the value associated with the key
	 * @private
	 */
	js_cols.HashMap.prototype.removeSwapped = function(value, key){
		this.remove(key);

	}


	/**
	 * Returns the value for the given key.  If the key is not found and the default
	 * value is not given this will return {@code undefined}.
	 * @param {*} key The key to get the value for.
	 * @param {*=} opt_val The value to return if no value is found for the given
	 *     key, defaults to undefined.
	 * @return {*} The value for the given key.
	 */
	js_cols.HashMap.prototype.get = function(key, opt_val) {
		var hash = this.getHash_ (key);
		if (js_cols.HashMap.hasHash_(this.map_, hash)) {
			return this.map_[hash].value;
		}
		return opt_val;
	};


	/**
	 * Adds a key-value pair to the map.
	 * @param {*} key The key.
	 * @param {*} value The value to insert.
	 */
	js_cols.HashMap.prototype.insert = function(key, value) {

		var hash = this.getHash_ (key);

		if (!(js_cols.HashMap.hasHash_(this.map_, hash))) {
			this.count_++;
			// Only change the version if we add a new key.
			this.version_++;
		}
		var pair = {};
		pair.value = value;
		pair.key = key;
		this.map_[hash] = pair;

	};

	/**
	 * Helper method for insertAll
	 * @param {*} key the key used for ordering and location
	 * @param {*} element the value associated with the key
	 * @private
	 */
	js_cols.HashMap.prototype.insertSwapped = function(element, key){
		this.insert(key, element);
	}



	/**
	 * Inserts a collection of key/value pairs into the map
	 * If the collection has no notion of keys (i.e. an Array or Set) each element
	 * is inserted as both key and value (mapping to it self)
	 * @param {js_cols.Collection || Object || Array} col the collection to insert
	 * @public
	 */
	js_cols.HashMap.prototype.insertAll = function(col){
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
	 * Removes a collection of key/value pairs into the map
	 * If the collection has no notion of keys (i.e. an Array or Set),
	 * the values in the collection are treated as keys in the map,
	 * and the values associated with those keys are removed.
	 * @param {js_cols.Collection || Array || Object} col the collection of values to remove
	 * @public
	 */
	js_cols.HashMap.prototype.removeAll = function(col){
		if (js_cols.typeOf(col) == "array"){
			for (var i = 0; i < col.length; i++){
				this.remove(col[i]);
			};
		}
		else if (js_cols.typeOf(col.forEach) == "function"){
			col.forEach(this.removeSwapped, this);
		}
		else if (js_cols.typeOf(col.getValues) == "function"){
			var arr = col.getValues();
			for (var i = 0; i < arr.length; i++){
				this.remove(arr[i]);
			};
		}
		else if (js_cols.typeOf(col) == "object") {
			for (var key in col){
				this.remove(col[key]);
			}
		}
	}

	/**
	 * Checks that all keys contained in the collection are also contained as keys in the map.
	 * If the collection has no notion of keys (i.e. an Array or a Set), the values of the collection
	 * will be interpreted as keys in this map.
	 * @param {js_cols.Collection || Array || Object} col the collection of values to check
	 * @return {Boolean}
	 * @public
	 */
	js_cols.HashMap.prototype.containsAll = function(col){
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
				if (!this.containsKey(key)){
					return false;
				};
			}
			return true;
		}
	};

	/**
	 * Clones a map and returns a new map.
	 * @return {!js_cols.HashMap} A new map with the same key-value pairs.
	 */
	js_cols.HashMap.prototype.clone = function() {
		return new js_cols.HashMap(this);
	};

	/**
	 * Calls a function on each key/value pair in the HashMap.
	 *
	 * @param {Function} f The function to call for each key/value pair. The function takes
	 *     three arguments: the value, the key, and the HashMap.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 */
	js_cols.HashMap.prototype.forEach = function(f, opt_obj) {
		for (var key in this.map_) {
			f.call(opt_obj, this.map_[key].value, this.map_[key].key, this);
		}
	};

	/**
	 * Calls a function on each key/value pair in the HashMap and returns true if any of
	 * those function calls returns a true-like value.
	 *
	 * @param {Function} f The function to call for each key/value pair. The function takes
	 *     three arguments: the value, the key and the HashMap, and returns a
	 *     boolean.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {boolean} Whether f evaluates to true for at least one key/value pair in the
	 *     HashMap.
	 */
	js_cols.HashMap.prototype.some = function(f, opt_obj) {
		for (var key in this.map_) {
			if (f.call(opt_obj, this.map_[key].value, this.map_[key].key, this)) {
				return true;
			}
		}
		return false;
	};


	/**
	 * Calls a function on each item in the HashMap and returns true only if every
	 * function call returns a true-like value.
	 *
	 * @param {Function} f The function to call for each key/value pair. The function takes
	 *     three arguments: the value, the key, and the HashMap, and returns a
	 *     boolean.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {boolean} Whether f evaluates to true for every item in the HashMap.
	 */
	js_cols.HashMap.prototype.every = function(f, opt_obj) {
		for (var key in this.map_) {
			if (!f.call(opt_obj, this.map_[key].value, this.map_[key].key, this)) {
				return false;
			}
		}
		return true;
	};

	/**
	 * Calls a function on each key/value pair in the HashMap and returns the results of
	 * those calls in an array.
	 *
	 * @param {!Function} f The function to call for each key/value pair. The function takes
	 *     three arguments: the value, the key, and the HashMap.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {!Array} The results of the function calls for each key/value pair in the
	 *     HashMap.
	 */
	js_cols.HashMap.prototype.map = function(f, opt_obj) {
		var rv = [];
		for (var key in this.map_) {
			rv.push(f.call(opt_obj, this.map_[key].value, this.map_[key].key, this));
		}
		return rv;
	};

	/**
	 * Calls a function on each key/value pair in the HashMap, if the function returns true, the key/value pair
	 * is inserted into a new HashMap that is returned when the map is fully traversed
	 *
	 * @param {!Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the HashMap.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {js_cols.HashMap} a new map with the key / value pairs that evaluated to true in the function calls 
	 *     
	 */
	js_cols.HashMap.prototype.filter = function(f, opt_obj) {
		var rv = new js_cols.HashMap()
		for (var key in this.map_) {
			if (f.call(opt_obj, this.map_[key].value, this.map_[key].key, this)) {
				rv.insert(this.map_[key].key , this.map_[key].value);
			}
		}
		return rv;
	};

	/**
	 * Finds all key/value pairs that are present in both this map and the given collection.
	 * If the collection has no notion of keys (i.e. a Set or an Array), each element of the collection
	 * will be treated as key, and it will be inserted to the returned map with its corresponding value from this map.
	 * This operation is O(n).
	 * @param {js_cols.Collection || Object} col A collection.
	 * @return {js_cols.HashMap} A new set containing all the key/value pairs (primitives
	 *     or objects) present in both this set and the given collection.
	 */
	js_cols.HashMap.prototype.intersection = function(col) {

		var colCount = js_cols.getCount(col);

		if (!(col instanceof js_cols.HashMap) && colCount > 5) {
			// Convert to a js_cols.Set so that js_cols.contains runs in
			// O(1) time instead of O(n) time.
			var map = new js_cols.HashMap();
			map.insertAll(col);
			col = map;
		}
		var rv = new js_cols.HashMap();
		if (js_cols.typeOf(col.get) == 'function'){
			for (var key in this.map_) {
				if (col.get.call(col, this.map_[key].key) == this.map_[key].value) {
					rv.insert(this.map_[key].key, this.map_[key].value);
				}
			};
		}
		else{
			for (var key in this.map_) {
				if (js_cols.contains.call(col, col, this.map_[key].key)) {
					rv.insert(this.map_[key].key, this.map_[key].value);
				}
			}
		}
		return rv;
	};

	/**
	 * Detects wheter all key/value pairs present in this map are also present in the given collection.
	 * If the collection has no notion of keys (i.e. a Set or an Array), the result will be whether the keys 
	 * in this map is a subset of the elements in the collection.
	 * This operation is O(n).
	 * @param {js_cols.Collection || Object} col A collection.
	 * @return {Boolean} wheter this map is a submap of col
	 *     
	 */
	js_cols.HashMap.prototype.isSubmapOf = function(col) {

		var colCount = js_cols.getCount(col);
		if (this.getCount() > colCount) return false;
		if (!(col instanceof js_cols.HashMap) && colCount > 5) {
			// Convert to a js_cols.Set so that js_cols.contains runs in
			// O(1) time instead of O(n) time.
			var map = new js_cols.HashMap();
			map.insertAll(col);
			col = map;
		}
		var i = 0;
		if (js_cols.typeOf(col.get) == 'function'){
			for (var key in this.map_) {
				if (col.get.call(col, this.map_[key].key) == this.map_[key].value) {
					i++;
				}
			};
		}
		else{
			for (var key in this.map_) {
				if (js_cols.contains.call(col, col, this.map_[key].key)) {
					i++;
				}
			}
		}
		return i == this.getCount();
	};


	/**
	 * Returns a new map in which all the keys and values are interchanged
	 * (keys become values and values become keys). If multiple keys map to the
	 * same value, the chosen transposed value is implementation-dependent.
	 *
	 * It acts very similarly to {goog.object.transpose(Object)}.
	 *
	 * @return {!js_cols.HashMap} The transposed map.
	 */
	js_cols.HashMap.prototype.transpose = function() {
		var transposed = new js_cols.HashMap();
		for (var propertyName in this.map_) {
			var key = this.map_[propertyName].key;
			var value = this.map_[propertyName].value;
			transposed.insert(value, key);
		}

		return transposed;
	};


	/**
	 * generates a "hash code" for an object, i. e.
	 * retrieving the object´s js_cols Uid
	 *
	 * @param val {*} the object generate a hash code for
	 * @return {String} a hash code
	 * @private
	 */
	js_cols.HashMap.prototype.getHash_ = function(val) {
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
js_cols.HashMap.hasHash_ = function(obj, key) {
	return Object.prototype.hasOwnProperty.call(obj, key);
};

