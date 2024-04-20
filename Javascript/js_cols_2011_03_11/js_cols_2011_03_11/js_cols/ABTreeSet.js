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
js_cols.provide('js_cols.ABTreeSet');
/**
 *
 * 
 *
 * js_cols.ABTreeSet provides the implementation of an (a,b) Tree Set datastructure. The tree
 * maintains a set of values in sorted order. The values can be
 * inserted and deleted efficiently in their sorted order as the tree enforces a logn
 * maximum height. This implementation provides guaranteed log(n) time cost for the
 * <tt>contains</tt>, <tt>insert</tt> and <tt>remove</tt>
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
 * @param {Integer} a the minimum number of child-nodes allowed pr node in this tree
 * @param {Integer} b the maximum number of child-nodes allowed pr node in this tree
 * @param {Function=} compare_func an optional compare function to compare the keys. This function should
 * take two values, a and b, and return x where:
 * <pre>
 *  x < 0 if a < b,
 *  x > 0 if a > b,
 *  x = 0 otherwise
 * </pre>
 * if not defined, a default compare function for <tt>numbers</tt> will be used.
 * @param {*} maxValue an arbitrary maximum value for keys. This argument should only be supplied if
 * a customized compare function are also supplied. If not defined, the maximum Integer value 9223372036854775807 is used.
 * This maximum key is used for a dummy element (<I>sentinel</I>) in the list of leafnodes.
 * @constructor
 * @public
 */



js_cols.ABTreeSet = function(a,b, compare_func, maxValue) {
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
	
	
	js_cols.ABTreeSet.prototype.default_compare = function (a,b) {
		if (a < b) return -1;
		else if (b < a) return 1;
		else return 0;
	};
	
	/**
	 * Removes all elements froms this tree 
	 * @public
	 */

	js_cols.ABTreeSet.prototype.clear = function(){

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
	 * Clones a set and returns a new set.
	 * @return {!js_cols.ABTreeSet} A new map with the same key-value pairs.
	 */
	js_cols.ABTreeSet.prototype.clone = function(){
		var rv = new js_cols.ABTreeSet(this.a, this.b, this.compare, this.LeafList.sentinel.key );
		rv.insertAll(this);
		return rv;

	};


js_cols.ABTreeSet.prototype.augmentLeafList = function(){
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
	 * Returns true if element is contained in the ABTreeSet, otherwise false
	 * @param {*} element
	 * @return {Boolean} 
	 * @public
	 */
	js_cols.ABTreeSet.prototype.contains = function(element){
		return this.get(element) != null;
	};

	/**
	 * Finds and returns the element "key" that is passed to the function
	 * @param {*} key
	 * @return {*} the value associated with the key if it exists in this tree, otherwise null
	 * @private used to check if an element is included
	 */
	js_cols.ABTreeSet.prototype.get = function(key){
		var retval = this.root.locateRec(key, this.height);
		if (this.compare (retval.key, key) == 0) {return retval.data;}
		else {return null;}
	};

	/**
	 * Finds and returns the the preceeding element of that passed to the function
	 * @param {*} element
	 * @return {*} the preceeding element or null if the supplied element is not in the tree
	 * @public
	 */
	js_cols.ABTreeSet.prototype.predecessor = function(element){
		if (!this.contains(element)) return null;
		var node = this.root.locateRec(element, this.height).previous;
		if (node !=this.LeafList.sentinel) return node.data;
		else return null;
	};

	/**
	 * Finds and returns the the succeeding element of that passed to the function
	 * @param {*} element
	 * @return {*} the succeeding element or null if the supplied element is not in the tree
	 * @public
	 */
	js_cols.ABTreeSet.prototype.successor = function(element){
		if (!this.contains(element)) return null;
		var node = this.root.locateRec(element, this.height).next;
		if (node !=this.LeafList.sentinel) return node.data;
		else return null;
	};

	/**
	 * Inserts a value into the tree
	 * @param {*} element the value
	 * @public
	 */
	js_cols.ABTreeSet.prototype.insert = function(element){
		var t = this.root.insertRec(element, element, this.height); 

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
	 * Inserts a all values from the collection into the tree
	 * @param {js_cols.Collection || Array || Object} col the collection of values to insert
	 * @public
	 */
	js_cols.ABTreeSet.prototype.insertAll = function(col){
		if (js_cols.typeOf(col) == "array"){
			for (var i = 0; i < col.length; i++){
				this.insert(col[i]);
			};
		}
		else if (js_cols.typeOf(col.forEach) == "function"){
			col.forEach(this.insert, this);
		}
		else if (js_cols.typeOf(col.getValues) == "function"){
			var arr = col.getValues();
			for (var i = 0; i < arr.length; i++){
				this.insert(arr[i]);
			};
		}
		else if (js_cols.typeOf(col) == "object") {
			for (var key in col){
				this.insert(col[key]);
			}
		}
	};

	/**
	 * Removes all values contained in the collection from the tree.
	 * If the collection has a notion of keys (a Map), the keys will be
	 * treated as values in this set.
	 * @param {js_cols.Collection || Array || Object} col the collection of values to remove
	 * @public
	 */
	js_cols.ABTreeSet.prototype.removeAll = function(col){
		if (js_cols.typeOf(col) == "array"){
			for (var i = 0; i < col.length; i++){
				this.remove(col[i]);
			};
		}
		else if (js_cols.typeOf(col.forEach) == "function"){
			col.forEach(this.remove, this);
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
	 * Checks that all values contained in the collection are also contained in the tree.
	 * If the collection has a notion of keys (a Map), the keys of the collection
	 * will be interpreted as values in this set.
	 * @param {js_cols.Collection || Array || Object} col the collection of values to check
	 * @return {Boolean}
	 * @public
	 */
	js_cols.ABTreeSet.prototype.containsAll = function(col){
		if (js_cols.typeOf(col) == "array"){
			for (var i = 0; i < col.length; i++){
				if (!this.contains(col[i]))
				{ return false;
				};
			};
			return true;
		}
		else if (js_cols.typeOf(col.forEach) == "function"){
			return col.every(this.contains, this);
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
				if (!this.contains(col[key])){
					return false;
				};
			}
			return true;
		}
	};


	/**
	 * Remove an element
	 * @param {*} element the element to remove
	 * @public
	 */
	js_cols.ABTreeSet.prototype.remove = function(element){
		this.root.removeRec(element, this.height);
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
	 * @param {js_cols.LinkedListNode} parent the parent nodfe of the leaf
	 * @private
	 */	
	js_cols.ABTreeSet.prototype.removeElement = function(leaf, parent, i){
				this.LeafList.removeFromList(leaf);
				parent.removeLocally(i);
	};

	/**
	 * NOTICE: the iterator returned by this method is unable to add, remove or update items
	 * @see js_cols.LinkedList.LinkedListIterator
	 * Returns an iterator over the leaf list, starting before the first node
	 * @param {*} key the starting key for the Iterator (if not present in the tree, nearest neighbor is used)
	 * @return {js_cols.LinkedList.LinkedListIterator} an iterator over the values in this tree
	 * @public
	 */
	js_cols.ABTreeSet.prototype.iterator = function(element){
		var iter = this.LeafList.iterator(0);
		delete iter.add;
		delete iter.remove;
		delete iter.set;
		if (element) iter.position = this.root.locateRec(element, this.height);
		return iter;
	};

	/**
	 * Returns the current size of the tree (number of elements)
	 * @return {Integer} 
	 * @public
	 */

	js_cols.ABTreeSet.prototype.getCount = function(){
		return this.LeafList.size;
	};

	/**
	 * Checks if the tree is empty
	 * @return {Boolean} 
	 * @public
	 */

	js_cols.ABTreeSet.prototype.isEmpty = function(){
		return this.LeafList.size ==0;
	};

	/**
	 * Returns the current height of the tree
	 * @return {Integer} 
	 * @public
	 */

	js_cols.ABTreeSet.prototype.getHeight = function(){
		return this.height;
	};

	/**
	 * Returns the minimum element in this tree
	 * @return {*} the minimum element in this tree
	 * @public
	 */

	js_cols.ABTreeSet.prototype.getMin = function(){
		return this.LeafList.sentinel.next.data;
	};

	/**
	 * Returns the maximum element in this tree
	 * @return {*} the maximum element in this tree
	 * @public
	 */

	js_cols.ABTreeSet.prototype.getMax = function(){
		return this.LeafList.sentinel.previous.data;
	};

	/**
	 * Returns an array of the elements in this tree, in sorted order
	 * @return {Array} an array of elements
	 * @public
	 */

	js_cols.ABTreeSet.prototype.getValues = function(){

		var retArray = [];
		this.traverse(function(x){
			retArray.push(x);
		});
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

	js_cols.ABTreeSet.prototype.range = function(from, to){

		var retArray = [];
		this.traverseFromTo(function(x){
			retArray.push(x);
		}, from, to);
		return retArray;

	};

	/**
	 * Calls a function on each item in the ABTreeSet.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the ABTreeSet.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 */
	js_cols.ABTreeSet.prototype.forEach = function(f, opt_obj) {
		for (var n = this.LeafList.sentinel.next; n != this.LeafList.sentinel; n = n.next) {
			f.call(opt_obj, n.data, n.key, this);
		}
	};

	/**
	 * Calls a function on each item in the ABTreeSet and returns true if any of
	 * those function calls returns a true-like value.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key and the ABTreeSet, and returns a
	 *     boolean.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {boolean} Whether f evaluates to true for at least one item in the
	 *     ABTreeSet.
	 */
	js_cols.ABTreeSet.prototype.some = function(f, opt_obj) {
		for (var n = this.LeafList.sentinel.next; n != this.LeafList.sentinel; n = n.next) {
			if (f.call(opt_obj, n.data, n.key, this)) {
				return true;
			}
		}
		return false;
	};


	/**
	 * Calls a function on each item in the ABTreeSet and returns true only if every
	 * function call returns a true-like value.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the ABTreeSet, and returns a
	 *     boolean.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {boolean} Whether f evaluates to true for every item in the ABTreeSet.
	 */
	js_cols.ABTreeSet.prototype.every = function(f, opt_obj) {
		for (var n = this.LeafList.sentinel.next; n != this.LeafList.sentinel; n = n.next) {
			if (!f.call(opt_obj, n.data, n.key, this)) {
				return false;
			}
		}
		return true;
	};

	/**
	 * Calls a function on each item in the ABTreeSet and returns the results of
	 * those calls in an array.
	 *
	 * @param {!Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the ABTreeSet.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {!Array} The results of the function calls for each item in the
	 *     ABTreeSet.
	 */
	js_cols.ABTreeSet.prototype.map = function(f, opt_obj) {
		var rv = [];
		for (var n = this.LeafList.sentinel.next; n != this.LeafList.sentinel; n = n.next) {
			rv.push(f.call(opt_obj, n.data, n.key, this));
		}
		return rv;
	};

		/**
	 * Calls a function on each element in the ABTreeSet, if the function returns true, the element
	 * is inserted into an array that is returned when the tree is fully traversed
	 *
	 * @param {!Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the ABTreeSet.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {Array=} The elements that evaluated to true in the function calls.
	 *     
	 */
	js_cols.ABTreeSet.prototype.filter = function(f, opt_obj) {
		var rv = [];
		for (var n = this.LeafList.sentinel.next; n != this.LeafList.sentinel; n = n.next) {
			if (f.call(opt_obj, n.data, n.key, this)) {
				rv.push(n.data);
			}
		}
		return rv;
	};

	/**
	 * Performs an in-order traversal of the tree and calls {@code func} with each
	 * traversed node. The traversal ends after traversing the tree's
	 * maximum node or when {@code func} returns a value that evaluates to true.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     two arguments: the value, and the ABTreeSet, and returns a
	 *     boolean.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @public
	 */

	js_cols.ABTreeSet.prototype.traverse =
		function(f, opt_obj) {
		var node = this.LeafList.sentinel.next;
		while (node != this.LeafList.sentinel){
			if (f.call(opt_obj, node.data, this)) return;
			node = node.next;
		}
	};

	/**
	 * Performs an in-order traversal of the tree and calls {@code func} with each
	 * traversed node, starting from the smallest node with a value >= to
	 * the specified start value. The traversal ends after traversing the tree's
	 * maximum node or when {@code func} returns a value that evaluates to true.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     two arguments: the value, and the ABTreeSet, and returns a
	 *     boolean.
	 * @param {Object=} fromKey traversal will begin on the
	 *    node with the smallest value >= fromKey.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @public
	 */
	js_cols.ABTreeSet.prototype.traverseFrom =
		function(f, fromKey, opt_obj) {
		var node = this.root.locateRec(fromKey, this.height);
		while (node != this.LeafList.sentinel){
			if (f.call(opt_obj, node.data, this)) return;
			node = node.next;
		}
	};

	/**
	 * Performs an in-order traversal of the tree and calls {@code func} with each
	 * traversed node, endning before the smallest node with a value >= to
	 * the specified end value, or when {@code func} returns a value that evaluates to true.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     two arguments: the value, and the ABTreeSet, and returns a
	 *     boolean.
	 * @param toKey the key before which the traversal will end.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @public
	 */

	js_cols.ABTreeSet.prototype.traverseTo =
		function(f, toKey, opt_obj) {
		var node = this.LeafList.sentinel.next;
		while (node != this.LeafList.sentinel && this.compare(node.key, toKey) < 0){
			if (f.call(opt_obj, node.data, this)) return;
			node = node.next;
		}
	};

	/**
	 * Performs an in-order traversal of the tree and calls {@code func} with each
	 * traversed node, starting from the smallest node with a value >= to
	 * the specified start value, endning before the smallest node with a value >= to
	 * the specified end value, or when {@code func} returns a value that evaluates to true.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     two arguments: the value, and the ABTreeSet, and returns a
	 *     boolean.
	 * @param {Object=} fromKey traversal will begin on the
	 *    node with the smallest value >= fromKey.
	 * @param toKey the key before which the traversal will end.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @public
	 */

	js_cols.ABTreeSet.prototype.traverseFromTo =
		function(f, fromKey, toKey, opt_obj) {
		var node = this.root.locateRec(fromKey, this.height);
		while (node != this.LeafList.sentinel && this.compare(node.key, toKey) < 0){
			if (f.call(opt_obj, node.data, this)) return;
			node = node.next;
		}
	};

	/**
	 * Performs an reverse-order traversal of the tree and calls {@code func} with each
	 * traversed node. The traversal ends after traversing the tree's
	 * maximum node or when {@code func} returns a value that evaluates to true.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     two arguments: the value, and the ABTreeSet, and returns a
	 *     boolean.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @public
	 */

	js_cols.ABTreeSet.prototype.traverseBackwards =
		function(f, opt_obj) {
		var node = this.LeafList.sentinel.previous;
		while (node != this.LeafList.sentinel){
			if (f.call(opt_obj, node.data, this)) return;
			node = node.previous;
		}
	};

	/**
	 * Helper method to locate position of a child within a node, using linear search
	 * @param {*} key 
	 * @param {Array} splitters
	 * @return {Integer}
	 * @private
	 **/

	js_cols.ABTreeSet.prototype.locateLocallyLinear = function(key, splitters){

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
	 * @return {Integer}
	 * @private
	 **/

	js_cols.ABTreeSet.prototype.locateLocallyBinary = function(key, splitters){

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
	 * @param {*} k
	 * @param {js_cols.LinkedList.Node} element
	 * @param {*} k
	 * @return {*} an object holding a js_cols.LinkedList.Node and a key
	 * @private
	 **/
	js_cols.ABTreeSet.prototype.addToLeafs = function(leaf, k, element){
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


	/**
	 * Tests whether the given collection contains all the elements in this set.
	 * Primitives are treated as equal if they have the same type and convert to the
	 * same string; objects are treated as equal if they are references to the same
	 * object.
	 * WARNING: This operation is not guaranteed to work correctly if col is a Map.
	 * This operation is O(n * O(col.contains)).
	 * Example: if col is another ABTreeSet of size m, running time is O(n log(m)),
	 * if col is an Array or LinkedList, running time is O(n * m),
	 * if col is a HashSet, running time is O(n).
	 * @param {js_cols.Set|Array|Object} col A collection.
	 * @return {boolean} True if this set is a subset of the given collection.
	 */
	js_cols.ABTreeSet.prototype.isSubsetOf = function(col) {
		var colCount = js_cols.getCount(col);
		if (this.getCount() > colCount) {
			return false;
		}
		
		var f = function (val){
			  return js_cols.contains.call(col, col, val)
			};
			if (this.every(f)) {return true;}
			else {return false;}
	
	};


	/**
	 * Finds all values that are present in both this set and the given collection.
	 * WARNING: This operation is not guaranteed to work correctly if col is a Map.
	 * This operation is O(n * O(col.contains)).
	 * Example: if col is another ABTreeSet of size m, running time is O(n log(m)),
	 * if col is an Array or LinkedList, running time is O(n * m),
	 * if col is a HashSet, running time is O(n).
	 * @param {js_cols.Set|Array|Object} col A collection.
	 * @return {js_cols.ABTreeSet} A new set containing all the values (primitives
	 *     or objects) present in both this set and the given collection.
	 */
	js_cols.ABTreeSet.prototype.intersection = function(col) {

		var  result = new js_cols.ABTreeSet(this.a, this.b, this.compare, this.LeafList.sentinel.key );
		for (var n = this.LeafList.sentinel.next; n != this.LeafList.sentinel; n = n.next) {
			if (col.contains.call(col, n.data, n.key, this)) {
				result.insert(n.data);
			}
		}
		return result;

	};




