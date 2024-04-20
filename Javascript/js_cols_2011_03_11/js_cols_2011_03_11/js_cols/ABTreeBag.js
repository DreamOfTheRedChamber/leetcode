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
js_cols.require('js_cols.ABTreeSet');
js_cols.provide('js_cols.ABTreeBag');
/**
 *
 *
 *
 * js_cols.ABTreeBag provides the implementation of an (a,b) Tree MultiSet datastructure. The tree
 * maintains a set of values in sorted order. A MultiSet allows dublicates. In case of dublicate values, 
 * the most recently inserted will be deleted when calling remove. The range function can be used to retrieve
 * all equal values. The values can be
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
 * @param {*} maxValue an arbitrary maximum value for keys. If not defined, the maximum Integer value 9223372036854775807 is used.
 * This maximum key is used for a dummy element (<I>sentinel</I>) in the list of leafnodes.
 * @see js_cols.ABTreeSet
 * @constructor
 * @extends js_cols.ABTreeSet
 */
js_cols.ABTreeBag = function(a,b, compare_func, maxValue){
js_cols.ABTreeSet.call(this,a,b, compare_func, maxValue);

};

js_cols.inherits(js_cols.ABTreeBag, js_cols.ABTreeSet);
	/**
	* @private
	*/
	js_cols.ABTreeBag.prototype.count_ = 0;
	
		/**
	 * Returns the current size of the tree (number of elements)
	 * @return {Number} 
	 * @public
	 */

	js_cols.ABTreeBag.prototype.getCount = function(){
		return this.count_;
	};

	// changing addToLeafs to allow multiple entries of an element
	/**
	* @private
	*/
	js_cols.ABTreeBag.prototype.addToLeafs = function(leaf, k, element){
		if (this.compare(leaf.key, k)==0) {
			while (leaf.sub) leaf = leaf.sub;
			var subNode = {
				"data" : element
			}
			leaf.sub = subNode;
			this.count_++;
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
			this.count_++;
			return t;
		}

	};
	
	/**
	 * Returns the minimum element in this tree
	 * @return {*} the value associated with the minimum key in this tree 
	 * @public
	 */

	js_cols.ABTreeBag.prototype.getMin = function(){
		return this.LeafList.sentinel.next.data;
	};

	/**
	 * Returns the maximum element in this tree
	 * @return {*} the value associated with the maximum key in this tree 
	 * @public
	 */

	js_cols.ABTreeBag.prototype.getMax = function(){
		return this.LeafList.sentinel.previous.data;
	};


	
	/**
	 * Finds and returns the preceeding element of that passed to the function
	 * @param {*} element
	 * @return {*} the preceeding element or null if the supplied element is not in the map
	 * @public
	 */
	js_cols.ABTreeBag.prototype.predecessor = function(element){
		if (!this.contains(element)) return null;
		var node = this.root.locateRec(element, this.height).previous;
		if (node !=this.LeafList.sentinel) return node.data;
		else return null;
	};

	/**
	 * Finds and returns the the succeeding element of that passed to the function
	 * @param {*} element
	 * @return {*} the succeeding element or null if the supplied element is not in the map
	 * @public
	 */
	js_cols.ABTreeBag.prototype.successor = function(element){
		if (!this.contains(element)) return null;
		var node = this.root.locateRec(element, this.height).next;
		if (node !=this.LeafList.sentinel) return node.data;
		else return null;
	};
	
		
	/**
	 * helper function for removal
	 * @param {number} i index in the parent node
	 * @param {js_cols.ABItem} parent the parent nodfe of the leaf
	 * @param {js_cols.LinkedListNode} parent the parent nodfe of the leaf
	 * @private
	 */	
	js_cols.ABTreeBag.prototype.removeElement = function(leaf, parent, i){
		this.count_--;
		if (!leaf.sub) {
		this.LeafList.removeFromList(leaf);
		parent.removeLocally(i);
		return leaf.data;
		}
		else {
			
			while(leaf.sub) {
			var prev = leaf;
			leaf = leaf.sub;
			}
			var retval = leaf.data;
			delete prev.sub;
			return retval;
		}
	};
	
	/**
	 * Performs an in-order traversal of the tree and calls {@code func} with each
	 * traversed node. The traversal ends after traversing the tree's
	 * maximum node or when {@code func} returns a value that evaluates to true.
	 *
	 * @param {Function} func Function to call on each traversed node.
	 * @public
	 */

	js_cols.ABTreeBag.prototype.traverse =
		function(func) {
		var node = this.LeafList.sentinel.next;
		while (node != this.LeafList.sentinel){
			var s = node;
			while (s){
			if (func(s.data)) return;
			s = s.sub;
			}
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
	js_cols.ABTreeBag.prototype.traverseFrom =
		function(func, fromKey) {
		var node = this.root.locateRec(fromKey, this.height);
		while (node != this.LeafList.sentinel){
			var s = node;
			while (s){
			if (func(s.data)) return;
			s = s.sub;
			}
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

	js_cols.ABTreeBag.prototype.traverseTo =
		function(func, toKey) {
		var node = this.LeafList.sentinel.next;
		while (node != this.LeafList.sentinel && this.compare(node.key, toKey) < 0){
			var s = node;
			while (s){
			if (func(s.data)) return;
			s = s.sub;
			}
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

	js_cols.ABTreeBag.prototype.traverseFromTo =
		function(func, fromKey, toKey) {
		var node = this.root.locateRec(fromKey, this.height);
		while (node != this.LeafList.sentinel && this.compare(node.key, toKey) < 0){
			var s = node;
			while (s){
			if (func(s.data)) return;
			s = s.sub;
			}
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
	js_cols.ABTreeBag.prototype.traverseBackwards =
		function(func, opt_startValue) {

		var node = this.LeafList.sentinel.previous;
		while (node != this.LeafList.sentinel){
			var s = node;
			while (s){
			if (func(s.data)) return;
			s = s.sub;
			}
			node = node.previous;
		}
	};

	/**
	 * Calls a function on each item in the ABTreeBag.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the ABTreeBag.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 */
	js_cols.ABTreeBag.prototype.forEach = function(f, opt_obj) {
		for (var n = this.LeafList.sentinel.next; n != this.LeafList.sentinel; n = n.next) {
			var s = n;
			while (s){
			f.call(opt_obj, s.data, n.key, this);
			s = s.sub;
			}
		}
	};

	/**
	 * Calls a function on each item in the ABTreeBag and returns true if any of
	 * those function calls returns a true-like value.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key and the ABTreeBag, and returns a
	 *     boolean.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {boolean} Whether f evaluates to true for at least one item in the
	 *     ABTreeBag.
	 */
	js_cols.ABTreeBag.prototype.some = function(f, opt_obj) {
		for (var n = this.LeafList.sentinel.next; n != this.LeafList.sentinel; n = n.next) {
			var s = n;
			while (s){
			if (f.call(opt_obj,s.data, n.key, this)) {
				return true;
			}
			s = s.sub;
			
			}
		}
		return false;
	};


	/**
	 * Calls a function on each item in the ABTreeBag and returns true only if every
	 * function call returns a true-like value.
	 *
	 * @param {Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the ABTreeBag, and returns a
	 *     boolean.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {boolean} Whether f evaluates to true for every item in the ABTreeBag.
	 */
	js_cols.ABTreeBag.prototype.every = function(f, opt_obj) {
		for (var n = this.LeafList.sentinel.next; n != this.LeafList.sentinel; n = n.next) {
			var s = n;
			while (s){
			if (!f.call(opt_obj,s.data, n.key, this)) {
				return false;
			}
			s = s.sub;
			}
		}
		return true;
	};

	/**
	 * Calls a function on each item in the ABTreeBag and returns the results of
	 * those calls in an array.
	 *
	 * @param {!Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the ABTreeBag.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {!Array} The results of the function calls for each item in the
	 *     ABTreeBag.
	 */
	js_cols.ABTreeBag.prototype.map = function(f, opt_obj) {
		var rv = [];
		for (var n = this.LeafList.sentinel.next; n != this.LeafList.sentinel; n = n.next) {
		var s = n;
			while (s){
			rv.push(f.call(opt_obj, s.data, n.key, this));
			s = s.sub;
		}
		}
		return rv;
	};

	/**
	 * Calls a function on each item in the ABTreeBag, if the function returns true, the element 
	 * is inserted into a new ABTreeBag that is returned when the tree is fully traversed
	 *
	 * @param {!Function} f The function to call for each item. The function takes
	 *     three arguments: the value, the key, and the ABTreeBag.
	 * @param {Object=} opt_obj The object context to use as "this" for the
	 *     function.
	 * @return {Array} a new bag with the elements that evaluated to true in the function calls 
	 *     
	 */
	js_cols.ABTreeBag.prototype.filter = function(f, opt_obj) {
		var rv = [];
		for (var n = this.LeafList.sentinel.next; n != this.LeafList.sentinel; n = n.next) {
		var s = n;
			while (s){
			if (f.call(opt_obj, s.data, n.key, this)) {
				rv.push( s.data);
			}
			s = s.sub;
		}
		}
		return rv;
	};

	
		/**
	 * Clones a bag and returns a new bag.
	 * @return {!js_cols.ABTreeBag} A new map with the same key-value pairs.
	 */
	js_cols.ABTreeBag.prototype.clone = function(){
		var rv = new js_cols.ABTreeBag(this.a, this.b, this.compare, this.LeafList.sentinel.key );
		rv.insertAll(this);
		return rv;

	}
	
	/**
	 * Removing the iterator method, as the LinkedList iterator will not work correctly on bags and multi maps
	 * @private
	 */
	js_cols.ABTreeBag.prototype.iterator = undefined;
	
	
