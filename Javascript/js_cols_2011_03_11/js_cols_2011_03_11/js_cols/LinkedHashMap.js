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

js_cols.require('js_cols.LinkedList');
js_cols.require('js_cols.HashMap');
js_cols.provide('js_cols.LinkedHashMap');

/**
 * Class for a LinkedHashMap datastructure, which combines O(1) map access for
 * key/value pairs with a linked list for a consistent iteration order. 
 * This implementation is based on goog.structs.LinkedMap from the google closure library,
 * but allows any type as keys. It is also possible to obtain an iterator over the values in this implentation,
 * and direct insertion before or after a given key is also supported.
 * Sample
 * usage:
 *
 * <pre>
 * var m = new js_cols.LinkedHashMap();
 * m.insert('param1', 'A');
 * m.insert('param2', 'B');
 * m.insert('param3', 'C');
 * alert(m.getKeys()); // param1, param2, param3
 *
 * var c = new js_cols.LinkedHashMap(5, true);
 * for (var i = 0; i < 10; i++) {
 *   c.insert('entry' + i, false);
 * }
 * alert(c.getKeys()); // entry9, entry8, entry7, entry6, entry5
 *
 * c.insert('entry5', true);
 * c.insert('entry1', false);
 * alert(c.getKeys()); // entry1, entry5, entry9, entry8, entry7
 * </pre>
 *
 *
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
 * - insertBefore           O(1)
 * - insertAfter            O(1)
 * - insertAll              O(m) m is the cardinality of the supplied collection
 * - map                    O(n * O(f)) f is the function supplied as argument
 * - peek                   O(1)
 * - peekLast               O(1)
 * - peekValue              O(1)
 * - pop                    O(1)
 * - remove                 O(1)
 * - removeAll              O(m logn) m is the cardinality of the supplied collection
 * - shift                  O(1)
 * - some                   O(n * O(f)) f is the function supplied as argument
 * - contains               O(n * O(f)) f is the function supplied as argument
 * </pre>
 *
 * WARNING: keys will be modified, a property named something like "js_cols_uid_2kczq5"
 * will be added. This liberates the user of implementing a getHashCode function, and
 * improves performance as hashing collisions are avoided.
 *
 * @param {number=} opt_maxCount The maximum number of objects to store in the
 *     LinkedHashMap. If unspecified or 0, there is no maximum.
 * @param {boolean=} isLFOcache When set, the LinkedHashMap stores items in order
 *     from most recently used to least recently used, instead of insertion
 *     order.
 * @constructor
 */

js_cols.LinkedHashMap = function(opt_maxCount, isLFOcache){

	this.list_ = new js_cols.LinkedList();
	this.augmentList();
	this.map_ = new js_cols.HashMap();
	this.maxCount_ = null || opt_maxCount;
	this.isCache_ = false || isLFOcache;
};

js_cols.LinkedHashMap.prototype.augmentList = function(){
	/**
	 * Direct insertion to the leaf list after a given node in the list.
	 * @param element the element after which the insertion should be
	 * @param newElement the new element to insert
	 * @private
	 **/
	this.list_.insertAfter = function(element, newElement){

		newElement.next = element.next;
		newElement.previous = element;
		element.next.previous = newElement;
		element.next = newElement;
		this.size ++;

	};

	/**
	 * Direct insertion to the leaf list before a given node in the list.
	 * @param element the element  before which the insertion should be
	 * @param newElement the new element to insert
	 * @private
	 **/

	this.list_.insertBefore = function(element, newElement){

		newElement.next = element;
		newElement.previous = element.previous;
		element.previous.next = newElement;
		element.previous = newElement;
		this.size ++;

	};

	/**
	 * Direct removal of a given node in the leaf list.
	 * @param element the node to remove
	 * @private
	 **/

	this.list_.removeFromList = function( element){

		element.previous.next = element.next;
		element.next.previous = element.previous;

		this.size --;

	};
	
};

	/**
	 * Finds a node and updates it to be the most recently used.
	 * @param {*} key The key of the node.
	 * @return {*} The node or null if not found.
	 * @private
	 */
js_cols.LinkedHashMap.prototype.findAndMoveToTop_ = function(key) {
		var node = this.map_.get(key);
		if (node) {
			if (this.isCache_) {
				this.list_.removeFromList(node);
				this.insert_(node);
			}
		}
		return node;
	};

	/**
	 * Sets a value for a given key. If this is a LRUcaching LinkedHashMap, this entry
	 * will become the most recently used.
	 * @param {*} key The key to set the value for.
	 * @param {*} value The value associated with the key
	 *     
	 */
js_cols.LinkedHashMap.prototype.insert = function(key, value) {
		var node = this.findAndMoveToTop_(key);
		if (node) {
			node.data = value;
		} else {
			node = {
					"key" : key,
					"data" : value
			};
			this.map_.insert(key, node);
			this.insert_(node);
		}
	};

	/**
	 * Helper method for insertAll
	 * 
	 * @param {*} key The key to set the value for.
	 * @param {*} value The value associated with the key
	 * @private    
	 */
js_cols.LinkedHashMap.prototype.insertSwapped = function(value, key) {
		this.insert(key, value);
	};


	/**
	 * Sets a value for a given key, and inserts them after a specified key.
	 * If this is a LRUcaching LinkedHashMap, a call to this method will be ignored.
	 * @param {*} exKey a key, after which the new key/value pair should be inserted
	 * @param {*} key The key to set the value for.
	 * @param {*} value The value associated with the key
	 * @return {boolean} whether the key/value pair was inserted
	 *     
	 */

js_cols.LinkedHashMap.prototype.insertAfter = function (exKey, key, value){

		var node = this.map_.get(exKey);
		if (node && !this.isCache_){
			var newNode = {
					"key" : key,
					"data" : value
			};
			this.list_.insertAfter(node, newNode);
			this.map_.insert(key, newNode);
			if (this.maxCount_ != null) {
				this.truncate_(this.maxCount_);
			}
			return true;
		};
		return false;
	};

	/**
	 * Sets a value for a given key, and inserts them before a specified key.
	 * If this is a LRUcaching LinkedHashMap, a call to this method will be ignored.
	 * @param {*} exKey a key, before which the new key/value pair should be inserted
	 * @param {*} key The key to set the value for.
	 * @param {*} value The value associated with the key
	 * @return {boolean} whether the key/value pair was inserted
	 *     
	 */

js_cols.LinkedHashMap.prototype.insertBefore = function (exKey, key, value){

		var node = this.map_.get(exKey);
		if (node && !this.isCache_){
			var newNode = {
					"key" : key,
					"data" : value
			};
			this.list_.insertBefore(node, newNode);
			this.map_.insert(key, newNode);
			if (this.maxCount_ != null) {
				this.truncate_(this.maxCount_);
			}
			return true;
		};
		return false;
	};

	/**
	 * Inserts a collection of key/value pairs into the LinkedHashMap
	 * @param {*} element the value
	 * @public
	 */
js_cols.LinkedHashMap.prototype.insertAll = function(col){
		if (js_cols.typeOf(col) == "array"){
			for (var i = 0; i < col.length; i++){
				this.insert(col[i]);
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
	};

	/**
	 * Removes a all values contained in the collection from the map
	 * The values in the collection are treated as keys in the map,
	 * and the values associated with those keys are removed.
	 * @param {js_cols.Collection || Array || Object} col the collection of values to remove
	 * @public
	 */
js_cols.LinkedHashMap.prototype.removeAll = function(col){
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
	};

	/**
	 * Checks that all values contained in the collection are also contained as keys in the Map
	 * @param {js_cols.Collection || Array || Object} col the collection of values to check
	 * @return {Boolean}
	 * @public
	 */
js_cols.LinkedHashMap.prototype.containsAll = function(col){
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
	 * Retrieves the value for a given key. If this is a LRU-caching LinkedHashMap, the
	 * entry will become the most recently used.
	 * @param {*} key The key to retrieve the value for.
	 * @param {*=} opt_val A default value that will be returned if the key is
	 *     not found, defaults to undefined.
	 * @return {*} The retrieved value.
	 */
js_cols.LinkedHashMap.prototype.get = function(key, opt_val) {
		var node = this.findAndMoveToTop_(key);
		return node ? node.data : opt_val;
	};

	/**
	 * Retrieves the value for a given key without updating the entry to be the
	 * most recently used.
	 * @param {string} key The key to retrieve the value for.
	 * @param {*=} opt_val A default value that will be returned if the key is
	 *     not found.
	 * @return {*} The retrieved value.
	 */
js_cols.LinkedHashMap.prototype.peekValue = function(key, opt_val) {
		var node = this.map_.get(key);
		return node ? node.data : opt_val;
	};

	/**
	 * Returns the value of the first node without making any modifications.
	 * @return {*} The value of the first node or undefined if the map is empty.
	 */
js_cols.LinkedHashMap.prototype.peek = function() {
		return this.list_.getFirst();
	};

	/**
	 * Returns the value of the last node without making any modifications.
	 * @return {*} The value of the last node or undefined if the map is empty.
	 */
js_cols.LinkedHashMap.prototype.peekLast = function() {
		return this.list_.getLast();
	};

	/**
	 * Removes the first node from the list and returns its value.
	 * @return {*} The value of the popped node, or undefined if the map was empty.
	 */
js_cols.LinkedHashMap.prototype.shift = function() {
		return this.popNode_(this.list_.sentinel.next);
	};

	/**
	 * Removes the last node from the list and returns its value.
	 * @return {*} The value of the popped node, or undefined if the map was empty.
	 */
js_cols.LinkedHashMap.prototype.pop = function() {
		return this.popNode_(this.list_.sentinel.previous);
	};


	/**
	 * Removes a value from the LinkedHashMap based on its key.
	 * @param {*} key The key to remove.
	 * @return {boolean} True if the entry was removed, false if the key was not
	 *     found.
	 */
js_cols.LinkedHashMap.prototype.remove = function(key) {
		var node = this.map_.get(key);
		if (node) {
			this.removeNode(node);
			return true;
		}
		return false;
	};

	/**
	 * Helper method for removeAll
	 * @param {*} key The key to remove.
	 * @private
	 */
js_cols.LinkedHashMap.prototype.removeSwapped = function(value, key) {

		this.remove(key);
	};


	/**
	 * Removes a node from the {@code LinkedHashMap}. It can be overridden to do
	 * further cleanup such as disposing of the node value.
	 * @param {*} node The LinkedList-node to remove.
	 * @private
	 */
js_cols.LinkedHashMap.prototype.removeNode = function(node) {
		this.list_.removeFromList(node);
		this.map_.remove(node.key);
	};

	/**
	 * * Returns the current size of the LinkedHashMap (number of key/value pairs)
	 * @return {number} The number of items currently in the LinkedHashMap.
	 */
js_cols.LinkedHashMap.prototype.getCount = function() {
		return this.map_.getCount();
	};


	/**
	 * Whether the map is empty
	 * @return {Boolean} True if the map is empty, false if it contains any key/value pairs.
	 */
js_cols.LinkedHashMap.prototype.isEmpty = function() {
		return this.map_.isEmpty();
	};

	/**
	 * Sets the maximum number of entries allowed in this object, truncating any
	 * excess objects if necessary.
	 * @param {number} maxCount The new maximum number of entries to allow.
	 */
js_cols.LinkedHashMap.prototype.setMaxCount = function(maxCount) {
		this.maxCount_ = maxCount || null;
		if (this.maxCount_ != null) {
			this.truncate_(this.maxCount_);
		}
	};


	/**
	 * Inserts all Valuesof this map into an Array and returns it
	 * @return {!Array} The list of the values in the appropriate order for
	 *     this LinkedHashMap.
	 */
js_cols.LinkedHashMap.prototype.getValues = function() {
		return this.list_.getValues();
	};

	/**
	 * Inserts all keys of this map into an Array and returns it
	 * @return {!Array} The list of the keys in the appropriate order for
	 *     this LinkedHashMap.
	 */
js_cols.LinkedHashMap.prototype.getKeys = function() {
		return this.map(function(val, key) {
			return key;
		});
	};


	/**
	 * Tests whether a provided value is currently in the LinkedHashMap. This does not
	 * affect item ordering in cache-style LinkedHashMaps.
	 * @param {*} value The value to check for.
	 * @return {boolean} Whether the value is in the LinkedHashMap.
	 */
js_cols.LinkedHashMap.prototype.containsValue = function(value) {
		return this.list_.contains(value);
	};


	/**
	 * Tests whether a provided key is currently in the LinkedHashMap. This does not
	 * affect item ordering in cache-style LinkedHashMaps.
	 * @param {*} key The key to check for.
	 * @return {boolean} Whether the key is in the LinkedHashMap.
	 */
js_cols.LinkedHashMap.prototype.containsKey = function(key) {
		return this.map_.containsKey(key);
	};

	/**
	 * Tests whether a provided key is currently in the LinkedHashMap. This does not
	 * affect item ordering in cache-style LinkedHashMaps.
	 * This operation is identical to containsKey
	 * @param {*} key The key to check for.
	 * @return {boolean} Whether the key is in the LinkedHashMap.
	 */
js_cols.LinkedHashMap.prototype.contains = function(key) {
		return this.containsKey(key);
	};
	
	/**
	 * Helper method for containsAll
	 * @param {*} key The key to check for.
	 * @return {boolean} Whether the key is in the LinkedHashMap.
	 * @private
	 */
js_cols.LinkedHashMap.prototype.containsSwapped = function(value, key) {
		return this.containsKey(key);
	};


	/**
	 * Removes all entries in this object.
	 */
js_cols.LinkedHashMap.prototype.clear = function() {
		this.truncate_(0);
	};

	/**
	 * Returns a shallow clone of this LinkedHashMap, containing the same key/value pairs.
	 * @return {js_cols.LinkedHashMap} the new LinkedHashMap.
	 */
js_cols.LinkedHashMap.prototype.clone = function() {
		var rv = new js_cols.LinkedHashMap(this.maxCount_, this.isCache_ );
		rv.insertAll(this);
		return rv;
	};

	/**
	 * Calls a function on each item in the LinkedHashMap.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the LinkedHashMap.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 */
js_cols.LinkedHashMap.prototype.forEach = function(f, opt_obj) {
		for (var n = this.list_.sentinel.next; n != this.list_.sentinel; n = n.next) {
			f.call(opt_obj, n.data, n.key, this);
		}
	};


	/**
	 * Calls a function on each item in the LinkedHashMap and returns the results of
	 * those calls in an array.
	 *
	 * @param {!Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the LinkedHashMap.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {!Array} The results of the function calls for each item in the
	 *     LinkedHashMap.
	 */
js_cols.LinkedHashMap.prototype.map = function(f, opt_obj) {
		var rv = [];
		for (var n = this.list_.sentinel.next; n != this.list_.sentinel; n = n.next) {
			rv.push(f.call(opt_obj, n.data, n.key, this));
		}
		return rv;
	};

	/**
	 * Calls a function on each item in the LinkedHashMap, if the function returns true, the key/value pair
	 * is inserted into a LinkedHashMap that is returned when all elements in the the map has been visited
	 *
	 * @param {!Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the LinkedHashMap.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {js_cols.LinkedHashMap} The key / value pairs that evaluated to true in the function calls for each item in the
	 *     LinkedHashMap.
	 */
js_cols.LinkedHashMap.prototype.filter = function(f, opt_obj) {
		var rv = new js_cols.LinkedHashMap(this.maxCount_ ,this.isCache_ );
		for (var n = this.list_.sentinel.next; n != this.list_.sentinel; n = n.next) {
			if (f.call(opt_obj, n.data, n.key, this)) {
				rv.insert(n.key, n.data);
			}
		}
		return rv;
	};

	/**
	 * Calls a function on each item in the LinkedHashMap and returns true if any of
	 * those function calls returns a true-like value.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the LinkedHashMap, and returns a
	 *     boolean.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {boolean} Whether f evaluates to true for at least one item in the
	 *     LinkedHashMap.
	 */
js_cols.LinkedHashMap.prototype.some = function(f, opt_obj) {
		for (var n = this.list_.sentinel.next; n != this.list_.sentinel; n = n.next) {
			if (f.call(opt_obj, n.data, n.key, this)) {
				return true;
			}
		}
		return false;
	};


	/**
	 * Calls a function on each item in the LinkedHashMap and returns true only if every
	 * function call returns a true-like value.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the LinkedHashMap, and returns a
	 *     boolean.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {boolean} Whether f evaluates to true for every item in the LinkedHashMap.
	 */
js_cols.LinkedHashMap.prototype.every = function(f, opt_obj) {
		for (var n = this.list_.sentinel.next; n != this.list_.sentinel; n = n.next) {
			if (!f.call(opt_obj, n.data, n.key, this)) {
				return false;
			}
		}
		return true;
	};

	/**
	 * Finds all key/value pairs that are present in both this map and the given collection.
	 * If the collection has no notion of keys (i.e. a Set or an Array), each element of the collection
	 * will be treated as key, and it will be inserted to the returned map with its corresponding value from this map.
	 * @param {js_cols.Collection || Object} col A collection.
	 * @return {js_cols.LinkedHashMap} A new set containing all the key/value pairs (primitives
	 *     or objects) present in both this set and the given collection.
	 */
js_cols.LinkedHashMap.prototype.intersection = function(col) {
		var rv = new js_cols.LinkedHashMap(this.maxCount_, this.isCache_ );
		if (js_cols.typeOf(col.get) == 'function'){
			for (var n = this.list_.sentinel.next; n != this.list_.sentinel; n = n.next) {
				if (col.get.call(col, n.key) == n.data) {
					rv.insert(n.key, n.data);
				}
			}
		}
		else{
			for (var n = this.list_.sentinel.next; n != this.list_.sentinel; n = n.next) {
				if (js_cols.contains.call(col, col, n.key)) {
					rv.insert(n.key, n.data);
				}
			}
		}
		return rv;
	};
	
		/**
	 * Detects wheter all key/value pairs present in this map are also present in the given collection.
	 * If the collection has no notion of keys (i.e. a Set or an Array), the result will be whether the keys 
	 * in this map is a subset of the elements in the collection.
	 * This operation is O(n * O(col.contains)).
	 * Example: if col is another LinkedHashMap, running time is O(n),
	 * if col is an Array or LinkedList, running time is O(n * m),
	 * if col is a HashSet, running time is O(n).
	 * @param {js_cols.Collection || Object} col A collection.
	 * @return {Boolean} wheter this map is a submap of col
	 *     
	 */
js_cols.LinkedHashMap.prototype.isSubmapOf = function(col) {
		var i = 0;
		if (js_cols.typeOf(col.get) == 'function'){
			for (var n = this.list_.sentinel.next; n != this.list_.sentinel; n = n.next) {
				if (col.get.call(col, n.key) == n.data) {
					i++;
				}
			}
		}
		else{
			for (var n = this.list_.sentinel.next; n != this.list_.sentinel; n = n.next) {
				if (js_cols.contains.call(col, col, n.key)) {
					i++;
				}
			}
		}
		return i == this.getCount();
	};


	/**
	 * Appends a node to the list. LinkedHashMap in cache mode adds new nodes to
	 * the head of the list, otherwise they are appended to the tail. If there is a
	 * maximum size, the list will be truncated if necessary.
	 *
	 * @param {*} node A LinkedList-node to insert.
	 * @private
	 */
js_cols.LinkedHashMap.prototype.insert_ = function(node) {
		if (this.isCache_) {

			this.list_.insertAfter(this.list_.sentinel, node);
		} else {
			this.list_.insertBefore(this.list_.sentinel, node);
		}

		if (this.maxCount_ != null) {
			this.truncate_(this.maxCount_);
		}
	};

	/**
	 * Removes elements from the LinkedHashMap if the given count has been exceeded.
	 * In cache mode removes nodes from the tail of the list. Otherwise removes
	 * nodes from the head.
	 * @param {number} count Number of elements to keep.
	 * @private
	 */
js_cols.LinkedHashMap.prototype.truncate_ = function(count) {
		for (var i = this.map_.getCount(); i > count; i--) {
			this.removeNode(this.isCache_ ? this.list_.sentinel.previous : this.list_.sentinel.next);
		}
	};

	/**
	 * Removes the node from the LinkedHashMap if it is not the head, and returns
	 * the node's value.
	 * @param {*} node The node to remove.
	 * @return {*} The value of the popped node.
	 * @private
	 */
js_cols.LinkedHashMap.prototype.popNode_ = function(node) {
		if (this.list_.sentinel != node) {
			this.removeNode(node);
		}
		return node.data;
	};

	/**
	 * NOTICE: the iterator returned by this method is unable to add, remove or update items
	 * Returns an iterator over the values of the list, starting before the first node, if no starting key is specified.
	 * @see {js_cols.LinkedList.LinkedListIterator}
	 * @param {*} key the starting key for the Iterator (if not present in the map, it will start from the beginning of the list)
	 * @return {js_cols.LinkedList.LinkedListIterator} an iterator over the values in this LinkedHashMap
	 * @public
	 */
js_cols.LinkedHashMap.prototype.iterator = function(key){
		var iter = this.list_.iterator(0);

		delete iter.add;
		delete iter.remove;
		delete iter.set;
		var pos = this.map_.get(key, false);
		if (pos){
			iter.position = pos;
		}
		return iter;
	};

