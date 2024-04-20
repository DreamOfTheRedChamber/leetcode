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
js_cols.require('js_cols.LinkedList');
js_cols.require('js_cols.ABItem');
js_cols.provide('js_cols.ABTreeMap');
/**
 * 
 *
 *
 * js_cols.ABTreeMap provides the implementation of an (a,b) Tree Map datastructure. The tree
 * maintains a set of key/value pairs in a order, sorted by the keys. The values can be
 * accessed efficiently in their sorted order since the tree enforces an O(logn)
 * maximum height. This implementation provides guaranteed log(n) time cost for the
 * <tt>containsKey</tt>, <tt>get</tt>, <tt>put</tt> and <tt>remove</tt>
 * operations.  Algorithms are adaptations of those in Mehlhorn and
 * Sanders <I>Algortihms and Datastructures - The basic toolbox</I>.<p>
 *
 * The assymptotic running time for important operations are below:
 * <pre>
 *   Method                 big-O
 * ----------------------------------------------------------------------------
 * - clear                  O(1)
 * - clone                  O(n logn)
 * - contains               O(logn)
 * - containsAll            O(m logn) m is the cardinality of the supplied collection
 * - every                  O(n * O(f)) f is the function supplied as argument
 * - filter                 O(n * O(f)) f is the function supplied as argument
 * - forEach                O(n * O(f)) f is the function supplied as argument
 * - get                    O(logn)
 * - getValues              O(n)
 * - insert                 O(logn)
 * - insertAll              O(m logn) m is the cardinality of the supplied collection
 * - map                    O(n * O(f)) f is the function supplied as argument
 * - remove                 O(logn)
 * - removeAll              O(m logn) m is the cardinality of the supplied collection
 * - some                   O(n * O(f)) f is the function supplied as argument
 * - contains               O(n * O(f)) f is the function supplied as argument
 * </pre>
 *
 * @param {Number} a the minimum number of child-nodes allowed pr node in this tree
 * @param {Number} b the maximum number of child-nodes allowed pr node in this tree
 * @param {Function=} compare_func an optional compare function to compare the keys. This function should
 * take two values, a and b, and return x where:
 * <pre>
 *  x < 0 if a < b,
 *  x > 0 if a > b,
 *  x = 0 otherwise
 * </pre>
 * if not defined, a default compare function for <tt>numbers</tt> will be used
 * @param {*} maxValue an arbitrary maximum value for keys. This argument should only be supplied if
 * a customized compare function are also supplied. If not defined, the maximum Integer value 9223372036854775807 is used.
 * This maximum key is used for a dummy element (<I>sentinel</I>) in the list of leafnodes.
 * @constructor
 * @public
 */



js_cols.ABTreeMap = function(a,b, compare_func, maxValue) {
	this.height = 1; // Tree height
	this.a = 3;
	this.b= 9;
	this.LeafList = new js_cols.LinkedList();
	// creating the dummy element in the list
	this.augmentLeafList();

	this.LeafList.sentinel.key = arguments[3] || 9223372036854775807;

	
	/**
	 * Comparison function used to compare values in the tree. This function should
	 * take two values, a and b, and return x where:
	 * <pre>
	 *  x < 0 if a < b,
	 *  x > 0 if a > b,
	 *  x = 0 otherwise
	 * </pre>
	 *
	 * @type {Function}
	 * @private
	 */
	this.compare = arguments[2] || this.default_compare;
	
	var s = [];
	var c = [];
	c[0] = this.LeafList.sentinel;

	/**
	 * Pointer to the root node of the tree.
	 * @type {js_cols.ABTree.ABItem}
	 * @private
	 */
	this.root = new js_cols.ABItem(c,s, this);



	if (a>1 && b>a+1){
		this.a = a;
		this.b = b;
	};
	
		/**
	 * Helper method to locate position of a child within a node.
	 * Will use linear search for b-values < 37
	 * @param {*} key 
	 * @param {Array} splitters
	 * @return {Number}
	 * @private
	 **/
	this.locateLocally;

	if (this.b < 36) {this.locateLocally = this.locateLocallyLinear;}
	else {this.locateLocally = this.locateLocallyBinary;}
	
	};
	
	/**
	 * A default compare function
	 * @private
	 */

	js_cols.ABTreeMap.prototype.default_compare = function (a,b) {
		if (a < b) return -1;
		else if (b < a) return 1;
		else return 0;
	};

	/**
	 * Removes all elements froms this tree 
	 * @public
	 */

	js_cols.ABTreeMap.prototype.clear = function(){

		this.LeafList.sentinel.next = this.LeafList.sentinel;
		this.LeafList.sentinel.previous = this.LeafList.sentinel;
		this.LeafList.size = 0;
		this.height = 1;
		var s = [];
		var c = [];
		c[0] = this.LeafList.sentinel;
		this.root = new js_cols.ABItem(c,s, this);

	};

	/**
	 * Clones a map and returns a new map.
	 * @return {!js_cols.ABTreeMap} A new map with the same key-value pairs.
	 */
	js_cols.ABTreeMap.prototype.clone = function(){
		var rv = new js_cols.ABTreeMap(this.a, this.b, this.compare, this.LeafList.sentinel.key );
		rv.insertAll(this);
		return rv;

	};
	
	/**
	 * Helper method to add functions to the leaflist
	 * @private
	 **/
	js_cols.ABTreeMap.prototype.augmentLeafList = function(){
	/**
	 * Direct insertion to the leaf list after a given node in the list.
	 * @param element the element after which the insertion should be
	 * @param newElement the new element to insert
	 * @private
	 **/
	this.LeafList.insertAfter = function(element, newElement){

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

	this.LeafList.insertBefore = function(element, newElement){

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

	this.LeafList.removeFromList = function( element){

		element.previous.next = element.next;
		element.next.previous = element.previous;

		this.size --;

	};

};
	/**
	 * Returns true if the key is associated with a value in this tree
	 * @param {*} key
	 * @return {Boolean} 
	 * @public
	 */
	js_cols.ABTreeMap.prototype.contains = function(key){
		return this.get(key) != null;
	};

	/**
	 * Whether the map contains the given key.
	 * @param {*} key The key to check for.
	 * @return {boolean} Whether the map contains the key.
	 * @private
	 */
	js_cols.ABTreeMap.prototype.containsSwapped = function(value, key){
		return this.contains(key);
	};

	/**
	 * Finds and returns the value associated with the key that is passed to the function
	 * @param {*} key
	 * @return {*} the value associated with the key if it exists in this tree, otherwise null
	 * @public
	 */
	js_cols.ABTreeMap.prototype.get = function(key){
		var retval = this.root.locateRec(key, this.height);
		if (this.compare (retval.key, key) == 0) {return retval.data;}
		else {return null;}
	};

	/**
	 * Finds and returns the value associated withthe preceeding key of that passed to the function
	 * @param {*} key
	 * @return {*} the preceeding value or null if the supplied key is not in the map
	 * @public
	 */
	js_cols.ABTreeMap.prototype.predecessor = function(key){
		if (!this.contains(key)) return null;
		var node = this.root.locateRec(key, this.height).previous;
		if (node !=this.LeafList.sentinel) return node.data;
		else return null;
	};

	/**
	 * Finds and returns the the succeeding element of that passed to the function
	 * @param {*} key
	 * @return {*} the succeeding value or null if the supplied key is not in the map
	 * @public
	 */
	js_cols.ABTreeMap.prototype.successor = function(key){
		if (!this.contains(key)) return null;
		var node = this.root.locateRec(key, this.height).next;
		if (node !=this.LeafList.sentinel) return node.data;
		else return null;
	};

	/**
	 * Inserts a key/value pair into the tree
	 * @param {*} key the key used for ordering and location
	 * @param {*} element the value associated with the key
	 * @public
	 */
	js_cols.ABTreeMap.prototype.insert = function(key, element){
		var t = this.root.insertRec(key, element, this.height); 

		if (t != null){
			var newSplitters = [];
			var newChildren = [];
			newSplitters[0] = t.k;
			newChildren[0] = t.handle;
			newChildren[1] = this.root;
			this.root = new js_cols.ABItem(newChildren, newSplitters, this);

			this.height++;
		}

	};
	/**
	 * Helper method for insertAll
	 * @param {*} key the key used for ordering and location
	 * @param {*} element the value associated with the key
	 * @private
	 */
	js_cols.ABTreeMap.prototype.insertSwapped = function(element, key){
		this.insert(key, element);
	};

	/**
	 * Inserts a collection of key/value pairs into the map
	 * If the collection has no notion of keys (i.e. an Array or Set) each element
	 * is inserted as both key and value (mapping to it self)
	 * @param {js_cols.Collection || Object || Array} col the collection to insert
	 * @public
	 */
	js_cols.ABTreeMap.prototype.insertAll = function(col){
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
	};

	/**
	 * Removes a all values contained in the collection from the tree
	 * The values in the collection are treated as keys in the tree,
	 * and the values associated with those keys are removed.
	 * @param {js_cols.Collection || Array || Object} col the collection of values to remove
	 * @public
	 */
	js_cols.ABTreeMap.prototype.removeAll = function(col){
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
	 * Checks that all keys contained in the collection are also contained as keys in the tree.
	 * If the collection has no notion of keys (i.e. an Array or a Set), the values of the collection
	 * will be interpreted as keys in this map.
	 * @param {js_cols.Collection || Array || Object} col the collection of values to check
	 * @return {Boolean}
	 * @public
	 */
	js_cols.ABTreeMap.prototype.containsAll = function(col){
		if (js_cols.typeOf(col) == "array"){
			for (var i = 0; i < col.length; i++){
				if (!this.contains(col[i]))
				{ return false;
				};
			};
			return true;
		}
		else if (js_cols.typeOf(col.every) == "function"){
			return col.every(this.containsSwapped, this);
		}
		else if (js_cols.typeOf(col.getValues) == "function"){
			var arr = col.getValues();
			for (var i = 0; i < arr.length; i++){
				if (!this.contains(arr[i])){
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
	};
	/**
	 * Remove the value associated with the key
	 * @param {*} key
	 * @public
	 */
	js_cols.ABTreeMap.prototype.remove = function(key){
		this.root.removeRec(key, this.height);
		if (this.root.children.length == 1 && this.height >1){
			var r = this.root.children[0];
			this.root = r;
			this.height--;
		}
	};
	
	/**
	 * helper function for removal
	 * @param {number} i index in the parent node
	 * @param {js_cols.ABItem} parent the parent nodfe of the leaf
	 * @param {js_cols.LinkedListNode} parent the parent node of the leaf
	 * @private
	 */	
	js_cols.ABTreeMap.prototype.removeElement = function(leaf, parent, i){
				this.LeafList.removeFromList(leaf);
				parent.removeLocally(i);
	};

	/**
	 * helper function for removeAll
	 * @param {*} key
	 * @param {*} value
	 * @private
	 */
	js_cols.ABTreeMap.prototype.removeSwapped = function(value,key){
		this.remove(key);
	};
	/**
	 * NOTICE: the iterator returned by this method is unable to add, remove or update items
	 * @see js_cols.LinkedList.LinkedListIterator
	 * Returns an iterator over the leaf list, starting before the first node
	 * @param {*} key the starting key for the Iterator (if not present in the tree, nearest neighbor is used)
	 * @return {js_cols.LinkedList.LinkedListIterator} an iterator over the values in this tree
	 * @public
	 */
	js_cols.ABTreeMap.prototype.iterator = function(key){
		var iter = this.LeafList.iterator(0);
		delete iter.add;
		delete iter.remove;
		delete iter.set;
		if (key) iter.position = this.root.locateRec(key, this.height);
		return iter;
	};

	/**
	 * Returns the current size of the tree (number of elements)
	 * @return {Number} 
	 * @public
	 */

	js_cols.ABTreeMap.prototype.getCount = function(){
		return this.LeafList.size;
	};

	/**
	 * Returns true if the current size of the tree is zero
	 * @return {Boolean} 
	 * @public
	 */

	js_cols.ABTreeMap.prototype.isEmpty = function(){
		return this.LeafList.size ==0;
	};

	/**
	 * Returns the current height of the tree
	 * @return {Number} 
	 * @public
	 */

	js_cols.ABTreeMap.prototype.getHeight = function(){
		return this.height;
	};

	/**
	 * Returns the value associated with the minimum key in this tree
	 * @return {*} the value associated with the minimum key in this tree 
	 * @public
	 */

	js_cols.ABTreeMap.prototype.getMin = function(){
		return this.LeafList.sentinel.next.data;
	};

	/**
	 * Returns the value associated with the maximum key in this tree
	 * @return {*} the value associated with the maximum key in this tree 
	 * @public
	 */

	js_cols.ABTreeMap.prototype.getMax = function(){
		return this.LeafList.sentinel.previous.data;
	};

	/**
	 * Returns an array of the values in this tree, ordered by their corresponding keys
	 * @return {Array} an array of values 
	 * @public
	 */

	js_cols.ABTreeMap.prototype.getValues = function(){

		var retArray = [];
		this.traverse(function(x){
			retArray.push(x);
		});
		return retArray;
	};

	/**
	 * Returns an array of the keys in this tree
	 * @return {Array} an array of Keys
	 * @public
	 */

	js_cols.ABTreeMap.prototype.getKeys = function(){
		var node  = this.LeafList.sentinel.next;
		var retArray = [];
		while (node != this.LeafList.sentinel){

			retArray.push(node.key);
			node = node.next;
		}
		return retArray;
	};

	/**
	 * Returns an array of the values in a given key range in this tree. 
	 * The 'from' key is inclusive, the 'to' key exclusive
	 * @param {*} from the smallest key in the range
	 * @param {*} to the successor of the largest key in the range
	 * @return {Array} an array of values 
	 * @public
	 */

	js_cols.ABTreeMap.prototype.range = function(from, to){

		var retArray = [];
		this.traverseFromTo(function(x){
			retArray.push(x);
		}, from, to);
		return retArray;

	};

	/**
	 * Performs an in-order traversal of the tree and calls {@code func} with each
	 * traversed node. The traversal ends after traversing the tree's
	 * maximum node or when {@code func} returns a value that evaluates to true.
	 *
	 * @param {Function} func Function to call on each traversed node.
	 * @public
	 */

	js_cols.ABTreeMap.prototype.traverse =
		function(func) {
		var node = this.LeafList.sentinel.next;
		while (node != this.LeafList.sentinel){
			if (func(node.data)) return;
			node = node.next;
		}
	};

	/**
	 * Performs an in-order traversal of the tree and calls {@code func} with each
	 * traversed node, starting from the smallest node with a value >= to
	 * the specified start value. The traversal ends after traversing the tree's
	 * maximum node or when {@code func} returns a value that evaluates to true.
	 *
	 * @param {Function} func Function to call on each traversed node.
	 * @param {Object=} fromKey traversal will begin on the
	 *    node with the smallest value >= fromKey.
	 * @public
	 */
	js_cols.ABTreeMap.prototype.traverseFrom =
		function(func, fromKey) {
		var node = this.root.locateRec(fromKey, this.height);
		while (node != this.LeafList.sentinel){
			if (func(node.data)) return;
			node = node.next;
		}
	};

	/**
	 * Performs an in-order traversal of the tree and calls {@code func} with each
	 * traversed node, endning before the smallest node with a value >= to
	 * the specified end value, or when {@code func} returns a value that evaluates to true.
	 *
	 * @param {Function} func Function to call on each traversed node.
	 * @param toKey the key before which the traversal will end.
	 * @public
	 */

	js_cols.ABTreeMap.prototype.traverseTo =
		function(func, toKey) {
		var node = this.LeafList.sentinel.next;
		while (node != this.LeafList.sentinel && this.compare(node.key, toKey) < 0){
			if (func(node.data)) return;
			node = node.next;
		}
	};

	/**
	 * Performs an in-order traversal of the tree and calls {@code func} with each
	 * traversed node, starting from the smallest node with a value >= to
	 * the specified start value, endning before the smallest node with a value >= to
	 * the specified end value, or when {@code func} returns a value that evaluates to true.
	 *
	 * @param {Function} func Function to call on each traversed node.
	 * @param {Object=} fromKey traversal will begin on the
	 *    node with the smallest value >= fromKey.
	 * @param toKey the key before which the traversal will end.
	 * @public
	 */

	js_cols.ABTreeMap.prototype.traverseFromTo =
		function(func, fromKey, toKey) {
		var node = this.root.locateRec(fromKey, this.height);
		while (node != this.LeafList.sentinel && this.compare(node.key, toKey) < 0){
			if (func(node.data)) return;
			node = node.next;
		}
	};
	/**
	 * Performs a reverse-order traversal of the tree and calls {@code func} with
	 * each traversed node. The traversal ends after traversing the
	 * tree's minimum node or when func returns a value that evaluates to true.
	 *
	 * @param {Function} func Function to call on each traversed node.
	 * @param {Object=} opt_startValue If specified, traversal will begin on the
	 *    node with the largest value <= opt_startValue.
	 * @public
	 */
	js_cols.ABTreeMap.prototype.traverseBackwards =
		function(func, opt_startValue) {

		var node = this.LeafList.sentinel.previous;
		while (node != this.LeafList.sentinel){
			if (func(node.data)) return;
			node = node.previous;
		}
	};

	/**
	 * Calls a function on each item in the ABTreeMap.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the ABTreeMap.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 */
	js_cols.ABTreeMap.prototype.forEach = function(f, opt_obj) {
		for (var n = this.LeafList.sentinel.next; n != this.LeafList.sentinel; n = n.next) {
			f.call(opt_obj, n.data, n.key, this);
		}
	};

	/**
	 * Calls a function on each item in the ABTreeMap and returns true if any of
	 * those function calls returns a true-like value.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key and the ABTreeMap, and returns a
	 *     boolean.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {boolean} Whether f evaluates to true for at least one item in the
	 *     ABTreeMap.
	 */
	js_cols.ABTreeMap.prototype.some = function(f, opt_obj) {
		for (var n = this.LeafList.sentinel.next; n != this.LeafList.sentinel; n = n.next) {
			if (f.call(opt_obj,n.data, n.key, this)) {
				return true;
			}
		}
		return false;
	};


	/**
	 * Calls a function on each item in the ABTreeMap and returns true only if every
	 * function call returns a true-like value.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the ABTreeMap, and returns a
	 *     boolean.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {boolean} Whether f evaluates to true for every item in the ABTreeMap.
	 */
	js_cols.ABTreeMap.prototype.every = function(f, opt_obj) {
		for (var n = this.LeafList.sentinel.next; n != this.LeafList.sentinel; n = n.next) {
			if (!f.call(opt_obj,n.data, n.key, this)) {
				return false;
			}
		}
		return true;
	};

	/**
	 * Calls a function on each item in the ABTreeMap and returns the results of
	 * those calls in an array.
	 *
	 * @param {!Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the ABTreeMap.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {!Array} The results of the function calls for each item in the
	 *     ABTreeMap.
	 */
	js_cols.ABTreeMap.prototype.map = function(f, opt_obj) {
		var rv = [];
		for (var n = this.LeafList.sentinel.next; n != this.LeafList.sentinel; n = n.next) {
			rv.push(f.call(opt_obj, n.data, n.key, this));
		}
		return rv;
	};

	/**
	 * Calls a function on each item in the ABTreeMap, if the function returns true, the key/value pair
	 * is inserted into a new ABTreeMap that is returned when the tree is fully traversed
	 *
	 * @param {!Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the ABTreeMap.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {js_cols.ABTreeMap} a new map with the key / value pairs that evaluated to true in the function calls 
	 *     
	 */
	js_cols.ABTreeMap.prototype.filter = function(f, opt_obj) {
		var rv = new js_cols.ABTreeMap(this.a, this.b, this.compare, this.LeafList.sentinel.key );
		for (var n = this.LeafList.sentinel.next; n != this.LeafList.sentinel; n = n.next) {
			if (f.call(opt_obj, n.data, n.key, this)) {
				rv.insert(n.key, n.data);
			}
		}
		return rv;
	};



	/**
	 * Finds all key/value pairs that are present in both this map and the given collection.
	 * If the collection has no notion of keys (i.e. a Set or an Array), each element of the collection
	 * will be treated as key, and it will be inserted to the returned map with its corresponding value from this map.
	 * This operation is O(n * O(col.contains)).
	 * Example: if col is another ABTreeSet of size m, running time is O(n log(m)),
	 * if col is an Array or LinkedList, running time is O(n * m),
	 * if col is a HashSet, running time is O(n).
	 * @param {js_cols.Collection || Object} col A collection.
	 * @return {js_cols.ABTreeMap} A new set containing all the key/value pairs (primitives
	 *     or objects) present in both this set and the given collection.
	 */
	js_cols.ABTreeMap.prototype.intersection = function(col) {
		var rv = new js_cols.ABTreeMap(this.a, this.b, this.compare, this.LeafList.sentinel.key );
		if (js_cols.typeOf(col.get) == 'function'){
			for (var n = this.LeafList.sentinel.next; n != this.LeafList.sentinel; n = n.next) {
				if (col.get.call(col, n.key) == n.data) {
					rv.insert(n.key, n.data);
				}
			}
		}
		else{
			for (var n = this.LeafList.sentinel.next; n != this.LeafList.sentinel; n = n.next) {
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
	 * Example: if col is another ABTreeSet of size m, running time is O(n log(m)),
	 * if col is an Array or LinkedList, running time is O(n * m),
	 * if col is a HashSet, running time is O(n).
	 * @param {js_cols.Collection || Object} col A collection.
	 * @return {Boolean} wheter this map is a submap of col
	 *     
	 */
	js_cols.ABTreeMap.prototype.isSubmapOf = function(col) {
		var i = 0;
		if (js_cols.typeOf(col.get) == 'function'){
			for (var n = this.LeafList.sentinel.next; n != this.LeafList.sentinel; n = n.next) {
				if (col.get.call(col, n.key) == n.data) {
					i++;
				}
			}
		}
		else{
			for (var n = this.LeafList.sentinel.next; n != this.LeafList.sentinel; n = n.next) {
				if (js_cols.contains.call(col, col, n.key)) {
					i++;
				}
			}
		}
		return i == this.getCount();
	};

	/**
	 * Helper method to locate position of a child within a node, using linear search
	 * @param {*} key 
	 * @param {Array} splitters
	 * @return {Number}
	 * @private
	 **/

	js_cols.ABTreeMap.prototype.locateLocallyLinear = function(key, splitters){

		var j =0;
		while (j < splitters.length && this.compare(splitters[j], key)<0){

			j++;
		}
		return j;
	};

	/**
	 * Helper method to locate position of a child within a node, using binary search
	 * @param {*} key 
	 * @param {Array} splitters
	 * @return {Number}
	 * @private
	 **/

	js_cols.ABTreeMap.prototype.locateLocallyBinary = function(key, splitters){

		var low =0;
		var high = splitters.length - 1;
		var mid;
		if (high >=0){
			while (low <= high){
				mid = Math.floor((low + high)/2);
				if (this.compare(splitters[mid], key)<0) {low = mid+1;}
				else if (this.compare(splitters[mid], key)>0) {high = mid-1;}
				else return mid;
			}

			return low;
		}
		else return 0;


	};


	/**
	 * Helper method used for insertion.
	 * @param {js_cols.LinkedList.Node} element
	 * @param {*} k
	 * @return {*} an object holding a js_cols.LinkedList.Node and a key
	 * @private
	 **/
	js_cols.ABTreeMap.prototype.addToLeafs = function(leaf, k, element){
		if (this.compare(leaf.key, k)==0) {
			leaf.data = element;
			return null;
		}
		else{


			var newNode = {};
			newNode.data = element;
			newNode.key = k;
			if (this.compare(k , leaf.key)<0){
				this.LeafList.insertBefore(leaf, newNode);

			}
			else {
				this.LeafList.insertAfter(leaf, newNode);
			}
			var t =	{
					"k": k,
					"handle": newNode
			};
			return t;
		}

	};


