//Copyright Thomas Stjernegaard Jeppesen. All Rights Reserved.

//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at

//http://www.apache.org/licenses/LICENSE-2.0

//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS-IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.

js_cols.require('js_cols.HashMultiMap');
js_cols.provide('js_cols.HashBag');

/**
 * 
 *
 * This file contains an implementation of a Hash Bag structure. 
 * It is based on goog.structs.Set from 
 * the google closure library.
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
 * - getValues              O(n)
 * - insert                 O(1)
 * - insertAll              O(m) m is the cardinality of the supplied collection
 * - map                    O(n * O(f)) f is the function supplied as argument
 * - remove                 O(1)
 * - removeAll              O(m logn) m is the cardinality of the supplied collection
 * - some                   O(n * O(f)) f is the function supplied as argument
 * - contains               O(n * O(f)) f is the function supplied as argument
 * </pre>
 *
 * This class implements a multi set data structure. Adding and removing is O(1). It
 * supports both object and primitive values. Be careful because you can add
 * both 1 and new Number(1), because these are not the same. You can even add
 * multiple new Number(1) because these are not equal.
 *
 * A set that can contain both primitives and objects.  Adding and removing
 * elements is O(1).  Primitives are treated as identical if they have the same
 * type and convert to the same string.  Objects are treated as identical only
 * if they are references to the same object.  WARNING: A js_cols.Set can
 * contain both 1 and (new Number(1)), because they are not the same.  WARNING:
 * Adding (new Number(1)) twice will yield two distinct elements, because they
 * are two different objects.  WARNING: Any object that is added to a
 * js_cols.Set will be modified!  Because js_cols.getUid() is used to
 * identify objects, every object in the set will be mutated.
 * This liberates the user of implementing a getHashCode function, and
 * improves performance as hashing collisions are avoided.
 * @param {*=} opt_map Map or Object to initialize the map with.
 * @param {...*} var_args If 2 or more arguments are present then they
 *     will be used as key-value pairs.
 * @constructor
 */

js_cols.HashBag = function(opt_map, opt_values) {
	this.map_ = new js_cols.HashMultiMap();
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
	 * Add a primitive or an object to the set.
	 * @param {*} element The primitive or object to add.
	 */
	js_cols.HashBag.prototype.insert = function(element) {
		this.map_.insert(element, element);
	};


	/**
	 * Adds all the values in the given collection to this set.
	 * @param {Array|Object} col A collection containing the elements to add.
	 */
	js_cols.HashBag.prototype.insertAll = function(col) {
		this.map_.insertAll(col);
	};


	/**
	 * @return {number} The number of elements in the set.
	 */
	js_cols.HashBag.prototype.getCount = function() {
		return this.map_.getCount();
	};




	/**
	 * Removes all values in the given collection from this Bag.
	 * If the collection has a notion of keys (a Map), the keys will be
	 * treated as values in this set.
	 * @param {Array|Object} col A collection containing the elements to remove.
	 */
	js_cols.HashBag.prototype.removeAll = function(col) {
		this.map_.removeAll(col);
	};



	/**
	 * Removes the given element from this set.
	 * @param {*} element The primitive or object to remove.
	 * @return {boolean} Whether the element was found and removed.
	 */
	js_cols.HashBag.prototype.remove = function(element) {
		return this.map_.remove(element);
	};


	/**
	 * Removes all elements from this set.
	 */
	js_cols.HashBag.prototype.clear = function() {
		this.map_.clear();
	};


	/**
	 * Tests whether this set is empty.
	 * @return {boolean} True if there are no elements in this set.
	 */
	js_cols.HashBag.prototype.isEmpty = function() {
		return this.map_.isEmpty();
	};


	/**
	 * Tests whether this set contains the given element.
	 * @param {*} element The primitive or object to test for.
	 * @return {Number} Number entries of the given element.
	 */
	js_cols.HashBag.prototype.contains = function(element) {
		return this.map_.containsKey(element);
	};


	/**
	 * Tests whether this set contains all the values in a given collection.
	 * Repeated elements in the collection are ignored, e.g.  (new
	 * js_cols.Set([1, 2])).containsAll([1, 1]) is True.
	 * @param {Object} col A collection-like object.
	 * @return {boolean} True if the set contains all elements.
	 */
	js_cols.HashBag.prototype.containsAll = function(col) {
		return this.map_.containsAll(col);
	};

	/**
	 * Finds all values that are present in both this bag and the given collection.
	 * NOTICE: intersection with bags does not deal with multiple entries of the same element.
	 * Example: intersection of HashBags [ 1, 2, 3, 3, 3, 4, 5] and [ 1, 2, 3, 3, 4, 5] would be [1, 2, 3, 4, 5]
	 * @param {js_cols.Collection || Object} col A collection.
	 * @return {js_cols.HashBag} A new set containing all the key/value pairs (primitives
	 *     or objects) present in both this set and the given collection.
	 */
	js_cols.HashBag.prototype.intersection = function(col) {
	
		
		var colCount = js_cols.getCount(col);

		if (!(col instanceof js_cols.HashBag) && colCount > 5) {
			// Convert to a js_cols.Set so that js_cols.contains runs in
			// O(1) time instead of O(n) time.
			var map = new js_cols.HashBag();
			map.insertAll(col);
			col = map;
		}
		var rv = new js_cols.HashBag();
	
	
			for (var hash in this.map_.map_) {
				if (js_cols.contains.call(col, col, this.map_.map_[hash].key)) {
					rv.insert(this.map_.map_[hash].value);
				}
			}
		
		return rv;
	};

	/**
	 * Detects wheter all values present in this bag are also present in the given collection.
	 * NOTICE: this operation does not deal with multiple entries of the same element.
	 * Example: the HashBag [ 1, 2, 3, 3, 3, 4, 5] would be a subset of the HashBag [ 1, 2, 3, 3, 4, 5]
	 * @param {js_cols.Collection || Object} col A collection.
	 * @return {Boolean} wheter this map is a submap of col
	 *     
	 */
	js_cols.HashBag.prototype.isSubsetOf = function(col) {
		
		
		var colCount = js_cols.getCount(col);
		if (this.getCount() > colCount) return false;
		if (!(col instanceof js_cols.HashBag) && colCount > 5) {
			// Convert to a goog.js_cols.Set so that goog.structs.contains runs in
			// O(1) time instead of O(n) time.
			col = new js_cols.HashBag(col);
		}
	
			var f = function (val){
			  return js_cols.contains.call(col, col, val)
			};
			return this.every(f);
				
	};


	/**
	 * Returns an array containing all the elements in this set.
	 * @return {Array} An array containing all the elements in this set.
	 */
	js_cols.HashBag.prototype.getValues = function() {
		return this.map_.getValues();
	};


	/**
	 * Creates a shallow clone of this set.
	 * @return {js_cols.Set} A new set containing all the same elements as
	 *     this set.
	 */
	js_cols.HashBag.prototype.clone = function() {
	return new js_cols.HashBag( this);
		
	};

	/**
	 * Calls a function on each item in the HashBag.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the HashBag.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 */
	js_cols.HashBag.prototype.forEach = function(f, opt_obj) {
		this.map_.forEach(f, opt_obj);
	};

	/**
	 * Calls a function on each item in the HashBag and returns true if any of
	 * those function calls returns a true-like value.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key and the HashBag, and returns a
	 *     boolean.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {boolean} Whether f evaluates to true for at least one item in the
	 *     RedBlackSet.
	 */
	js_cols.HashBag.prototype.some = function(f, opt_obj) {
		return this.map_.some(f, opt_obj);
	};


	/**
	 * Calls a function on each item in the HashBag and returns true only if every
	 * function call returns a true-like value.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the HashBag, and returns a
	 *     boolean.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {boolean} Whether f evaluates to true for every item in the HashBag.
	 */
	js_cols.HashBag.prototype.every = function(f, opt_obj) {
		return this.map_.every(f, opt_obj);
	};
	
	/**
	 * Calls a function on each element in the HashSet, if the function returns true, the element
	 * is inserted into an Array that is returned when the tree is fully traversed
	 *
	 * @param {!Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the HashSet.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {Array} The elements that evaluated to true in the function calls 
	 *    
	 */
	js_cols.HashBag.prototype.filter = function(f, opt_obj) {
		return new this.map_.filter(f, opt_obj).getValues();;
	};
	
		/**
	 * Calls a function on each item in the HashSet and returns the results of
	 * those calls in an array.
	 *
	 * @param {!Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the ABTreeMap.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {!Array} The results of the function calls for each item in the
	 *     HashSet.
	 */
	js_cols.HashBag.prototype.map = function(f, opt_obj) {
		return this.map_.map(f, opt_obj);
	};



	/**
	 * Tests whether the given collection consists of the same elements as this set,
	 * regardless of order, without repetition.  Primitives are treated as equal if
	 * they have the same type and convert to the same string; objects are treated
	 * as equal if they are references to the same object.  This operation is O(n).
	 * @param {Object} col A collection.
	 * @return {boolean} True if the given collection consists of the same elements
	 *     as this set, regardless of order, without repetition.
	 */
	js_cols.HashBag.prototype.equals = function(col) {
		if (!(col instanceof js_cols.HashBag)) {
		return false;
		}
		return this.map_.equals(col.map_);
	};



