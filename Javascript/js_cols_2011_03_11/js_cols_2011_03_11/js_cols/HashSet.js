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

js_cols.require('js_cols.HashMap');
js_cols.provide('js_cols.HashSet');

/**
 * 
 *
 * This file contains an implementation of a Hash Set structure. 
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
 * This class implements a set data structure. Inserting and removing is O(1). It
 * supports both object and primitive values. Be careful because you can insert
 * both 1 and new Number(1), because these are not the same. You can even insert
 * multiple new Number(1) because these are not equal.
 *
 * A set that can contain both primitives and objects.  Inserting and removing
 * elements is O(1).  Primitives are treated as identical if they have the same
 * type and convert to the same string.  Objects are treated as identical only
 * if they are references to the same object.  WARNING: A js_cols.Set can
 * contain both 1 and (new Number(1)), because they are not the same.  WARNING:
 * inserting (new Number(1)) twice will yield two distinct elements, because they
 * are two different objects.  WARNING: Any object that is inserted to a
 * js_cols.Set will be modified!  Because js_cols.getUid() is used to
 * identify objects, every object in the set will be mutated.
 * This liberates the user of implementing a getHashCode function, and
 * improves performance as hashing collisions are avoided.
 * @param {Array|Object=} opt_values Initial values to start with.
 * @constructor
 */

js_cols.HashSet = function(opt_values) {
	this.map_ = new js_cols.HashMap;
	
	if (opt_values) this.insertAll(opt_values);

};
	/**
	 * insert a primitive or an object to the set.
	 * @param {*} element The primitive or object to insert.
	 */
	js_cols.HashSet.prototype.insert = function(element) {
		this.map_.insert(element, element);
	};

	/**
	 * inserts all the values in the given collection to this set.
	 * @param {Array|Object} col A collection containing the elements to insert.
	 */
	js_cols.HashSet.prototype.insertAll = function(col) {
		this.map_.insertAll(col);
	};


	/**
	 * 
	 * @return {number} The number of elements in the set.
	 */
	js_cols.HashSet.prototype.getCount = function() {
		return this.map_.getCount();
	};


	/**
	 * Removes all values in the given collection from this set.
	 * If the collection has a notion of keys (a Map), the keys will be
	 * treated as values in this set.
	 * @param {Array|Object} col A collection containing the elements to remove.
	 */
	js_cols.HashSet.prototype.removeAll = function(col) {
		this.map_.removeAll(col);
	};


	/**
	 * Removes the given element from this set.
	 * @param {*} element The primitive or object to remove.
	 * @return {boolean} Whether the element was found and removed.
	 */
	js_cols.HashSet.prototype.remove = function(element) {
		return this.map_.remove(element);
	};



	/**
	 * Removes all elements from this set.
	 */
	js_cols.HashSet.prototype.clear = function() {
		this.map_.clear();
	};


	/**
	 * Tests whether this set is empty.
	 * @return {boolean} True if there are no elements in this set.
	 */
	js_cols.HashSet.prototype.isEmpty = function() {
		return this.map_.isEmpty();
	};


	/**
	 * Tests whether this set contains the given element.
	 * @param {*} element The primitive or object to test for.
	 * @return {boolean} True if this set contains the given element.
	 */
	js_cols.HashSet.prototype.contains = function(element) {
		return this.map_.containsKey(element);
	};


	/**
	 * Tests whether this set contains all the values in a given collection.
	 * Checks that all keys contained in the collection are also contained as keys in the map.
	 * If the collection has a notion of keys (a Map), the keys of the collection
	 * will be interpreted as values in this set.
	 * Repeated elements in the collection are ignored, e.g.  (new
	 * js_cols.Set([1, 2])).containsAll([1, 1]) is True.
	 * @param {Object} col A collection-like object.
	 * @return {boolean} True if the set contains all elements.
	 */
	js_cols.HashSet.prototype.containsAll = function(col) {
		return this.map_.containsAll(col);
	};


	/**
	 * Finds all values that are present in both this set and the given collection.
	 * WARNING: This operation is not guaranteed to work correctly if col is a Map.
	 * This operation is O(n).
	 * @param {js_cols.Set|Array|Object} col A collection.
	 * @return {js_cols.Set} A new set containing all the values (primitives
	 *     or objects) present in both this set and the given collection.
	 */
	js_cols.HashSet.prototype.intersection = function(col) {
		return this.map_.intersection(col);
	};


	/**
	 * Returns an array containing all the elements in this set.
	 * @return {Array} An array containing all the elements in this set.
	 */
	js_cols.HashSet.prototype.getValues = function() {
		return this.map_.getValues();
	};


	/**
	 * Creates a shallow clone of this set.
	 * @return {js_cols.Set} A new set containing all the same elements as
	 *     this set.
	 */
	js_cols.HashSet.prototype.clone = function() {
		return new js_cols.HashSet(this);
	};

	/**
	 * Calls a function on each item in the HashSet.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the HashSet.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 */
	js_cols.HashSet.prototype.forEach = function(f, opt_obj) {
		this.map_.forEach(f, opt_obj);
	};

	/**
	 * Calls a function on each item in the HashSet and returns true if any of
	 * those function calls returns a true-like value.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key and the HashSet, and returns a
	 *     boolean.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {boolean} Whether f evaluates to true for at least one item in the
	 *     RedBlackSet.
	 */
	js_cols.HashSet.prototype.some = function(f, opt_obj) {
		return this.map_.some(f, opt_obj);
	};


	/**
	 * Calls a function on each item in the HashSet and returns true only if every
	 * function call returns a true-like value.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the HashSet, and returns a
	 *     boolean.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {boolean} Whether f evaluates to true for every item in the HashSet.
	 */
	js_cols.HashSet.prototype.every = function(f, opt_obj) {
		return this.map_.every(f, opt_obj);
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
	js_cols.HashSet.prototype.map = function(f, opt_obj) {
		return this.map_.map(f, opt_obj);
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
	js_cols.HashSet.prototype.filter = function(f, opt_obj) {
		return new this.map_.filter(f, opt_obj).getValues();;
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
	js_cols.HashSet.prototype.equals = function(col) {
		return this.getCount() == js_cols.getCount(col) && this.isSubsetOf(col);
	};


	/**
	 * Tests whether the given collection contains all the elements in this set.
	 * WARNING: This operation is not guaranteed to work correctly if col is a Map.
	 * Primitives are treated as equal if they have the same type and convert to the
	 * same string; objects are treated as equal if they are references to the same
	 * object.  This operation is O(n).
	 * @param {Object} col A collection.
	 * @return {boolean} True if this set is a subset of the given collection.
	 */
	js_cols.HashSet.prototype.isSubsetOf = function(col) {
		return this.map_.isSubmapOf(col);
	};

