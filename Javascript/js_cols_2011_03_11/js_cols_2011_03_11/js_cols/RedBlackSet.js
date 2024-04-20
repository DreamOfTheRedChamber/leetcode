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
js_cols.require('js_cols.RBnode');
js_cols.provide('js_cols.RedBlackSet');

/**
 *
 * 
 *
 * js_cols.RedBlackSet provides the implementation of a Red Black Tree Set datastructure. The tree
 * maintains a set of values in sorted order. The values can be
 * inserted and deleted efficiently in their sorted order as the tree enforces a logn
 * maximum height. This implementation provides guaranteed log(n) time cost for the
 * <tt>contains</tt>, <tt>insert</tt> and <tt>remove</tt>
 * operations.  Algorithms are adaptations of those in Thomas H. Cormen, Charles E. Leiserson, 
 * Ronald L. Rivest, Clifford Stein <I>Introduction to Algorithms, second edition</I>.<p>
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
 * @param {Function=} compare_func an optional compare function to compare the keys. This function should
 * take two values, a and b, and return x where:
 * <pre>
 *  x < 0 if a < b,
 *  x > 0 if a > b,
 *  x = 0 otherwise
 * </pre>
 * if not defined, a default compare function for <tt>numbers</tt> will be used
 * @constructor
 * @public
 */


js_cols.RedBlackSet = function(compare_func){

	this.RED = true; 
	this.BLACK = false;
	this.size = 0;
	this.sentinel = new js_cols.RBnode(this);
	this.sentinel.color = this.BLACK;
	this.root = this.sentinel; // when the tree is empty, root = sentinel 
	this.root.parent = this.sentinel;
	
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
	this.compare = compare_func || this.default_compare;
	
};
	
		/**
		* A default compare function, if compare_func is not specified.
		* @private
		*/
		js_cols.RedBlackSet.prototype.default_compare = function (a,b) {
		if (a < b) return -1;
		else if (b < a) return 1;
		else return 0;
	};

	
		/**
	 * Clones a set and returns a new set.
	 * @return {!js_cols.RedBlackSet} A new map with the same key-value pairs.
	 */
	js_cols.RedBlackSet.prototype.clone = function(){
		var rv = new js_cols.RedBlackSet(this.compare);
		rv.insertAll(this);
		return rv;

	};
	
	/**
	 * Removes all elements from this set
	 * 
	 */
	js_cols.RedBlackSet.prototype.clear = function(){
		this.size = 0;
	this.sentinel = new js_cols.RBnode(this);
	this.sentinel.color = this.BLACK;
	this.root = this.sentinel; // when the tree is empty, root = sentinel 
	this.root.parent = this.sentinel;

	};
	
	/**
		* A helper function, used for tree balancing
		* @private
		*/
	js_cols.RedBlackSet.prototype.leftRotate = function(x){
		
		var y = x.right;
		x.right = y.left;
		if (y.left != this.sentinel) y.left.parent= x;
		y.parent = x.parent;
		if (x.parent == this.sentinel){
			this.root = y;
		}
		else if(x==x.parent.left){
			x.parent.left = y;
		}
		else {
			x.parent.right = y;
		}
		y.left = x;
		x.parent = y;

	};
/**
		* A helper function, used for tree balancing
		* @private
		*/
	js_cols.RedBlackSet.prototype.rightRotate= function(x){
		
		var y = x.left;
		x.left = y.right;
		if (y.right != this.sentinel)y.right.parent= x;
		y.parent = x.parent;
		if (x.parent == this.sentinel){
			this.root = y;
		}
		else if(x==x.parent.right){
			x.parent.right = y;
		}
		else {
			x.parent.left = y;
		}
		y.right = x;
		x.parent = y;

	};
/**
	 * Inserts a key/value pair into the tree
	 * @param {*} key the key used for ordering and location
	 * @param {*} element the value associated with the key
	 * @public
	 */
	js_cols.RedBlackSet.prototype.insert = function(key){
	
		if (!this.contains(key)){
		
		var z = new js_cols.RBnode(this);
		z.key = key;
		var y = this.sentinel;
		var x = this.root;
		while (x != this.sentinel){
			y=x;
			//if (z.key < x.key) x = x.left;
			if (this.compare(z.key, x.key) <0) x = x.left;
			else x=x.right;
		}
		z.parent = y;
		if (y == this.sentinel){
			this.root = z;
		}
		//else if(z.key < y.key){
		else if(this.compare(z.key, y.key) < 0){
			y.left = z;
		}
		else {
			y.right = z;
		}
		z.left = this.sentinel;
		z.right = this.sentinel;
		z.color = this.RED;
		this.insertFixup(z);
		this.size++;
		}
		else{
		var node = this.get_(key);
		node.key = key;
		}
	};
	

	/**
		* A helper function, used to reestablish the tree invariants after insertion of a node
		* @private
		*/
	js_cols.RedBlackSet.prototype.insertFixup = function(z) {

        while (z != this.sentinel && z != this.root && z.parent.color == this.RED) {
        	if (z.parent == z.parent.parent.left){
        		var y = z.parent.parent.right;
        		if (y.color == this.RED){
        			z.parent.color = this.BLACK;
        			y.color = this.BLACK;
        			z.parent.parent.color = this.RED;
        			z = z.parent.parent;
        		}
        		else
        		{
        			if (z == z.parent.right){
        				z = z.parent;
        				this.leftRotate(z);
        			}
        			z.parent.color = this.BLACK;
        			z.parent.parent.color = this.RED;
        			if (z.parent.parent != this.sentinel) this.rightRotate(z.parent.parent);
        		}
        		}else{
        			var y = z.parent.parent.left;
        			if (y.color == this.RED){
        				z.parent.color = this.BLACK;
        				y.color = this.BLACK;
        				z.parent.parent.color = this.RED;
        				z = z.parent.parent;
        			}else{
        				if (z == z.parent.left){
        					z=z.parent;
        					this.rightRotate(z);
        				}
        				z.parent.color = this.BLACK;
        				z.parent.parent.color = this.RED;
        				if (z.parent.parent != this.sentinel) this.leftRotate(z.parent.parent);
        			}
        	}
        }
        this.root.color = this.BLACK;
	};

	/**
	*	Deletes a node in the tree
	* @param {js_cols.RBnode} z the node to delete
	* @private
	*/
js_cols.RedBlackSet.prototype.delete_ = function(z){
		var y;
		var x;
		if (z.left == this.sentinel || z.right == this.sentinel){
			y = z;
		}
		else {
			y = this.successor_(z);
		}
		
		if (y.left != this.sentinel){
			x = y.left;
		}
		else {
			x = y.right;
		}
		x.parent = y.parent;
		if (y.parent == this.sentinel){
			this.root = x;
		}
		else if (y == y.parent.left){
			y.parent.left = x;
		}
		else {
			y.parent.right = x;
		}

		if (y != z){
			z.key = y.key;
		}
		if (y.color == this.BLACK){
			this.deleteFixup(x);
		}
		this.size--;
		//return y;

	};

/**
		* A helper function, used to reestablish the tree invariants after deletion of a node
		* @param x {js_cols.RBnode}
		* @private
		*/
js_cols.RedBlackSet.prototype.deleteFixup = function(x) {
	
		while (x != this.root && x.color == this.BLACK) {
            if (x == x.parent.left) {
                var w = x.parent.right;

                if (w.color == this.RED) {
                    w.color = this.BLACK;
                    x.parent.color = this.RED;
                    this.leftRotate(x.parent);
                    w = x.parent.right;
                }

                if (w.left.color  == this.BLACK &&
                    w.right.color == this.BLACK) {
                    w.color = this.RED;
                    x = x.parent;
                } else {
                    if (w.right.color == this.BLACK) {
                    	w.left.color = this.BLACK;
                        w.color = this.RED;
                        this.rightRotate(w);
                        w = x.parent.right;
                    }
                    w.color = x.parent.color;
                    x.parent.color = this.BLACK;
                    w.right.color = this.BLACK;
                    this.leftRotate(x.parent);
                    x = this.root;
                }
            } else { 
                var w = x.parent.left;

                if (w.color == this.RED) {
                    w.color = this.BLACK;
                    x.parent.color = this.RED;
                    this.rightRotate(x.parent);
                    w = x.parent.left;
                }

                if (w.right.color == this.BLACK &&
                   w.left.color == this.BLACK) {
                    w.color =  this.RED;
                    x = x.parent;
                } else {
                    if (w.left.color == this.BLACK) {
                        w.right.color = this.BLACK;
                        w.color = this.RED;
                        this.leftRotate(w);
                        w = x.parent.left;
                    }
                    w.color = x.parent.color;
                    x.parent.color = this.BLACK;
                    w.left.color = this.BLACK;
                    this.rightRotate(x.parent);
                    x = this.root;
                }
            }
        }

       x.color = this.BLACK;
        
	   
	};
	/**
	 * Remove the key and the value associated with it
	 * @param {*} key
	 * @public
	 */
	js_cols.RedBlackSet.prototype.remove = function(key){
		var x = this.get_(key);
		if (x != this.sentinel){
		var retval = x.key
		this.delete_(x);
		return retval;
		}
		else return null;
	};
	
		/**
	 * helper function for removeAll
	 * @param {*} key
	 * @param {*} value
	 * @private
	 */
	js_cols.RedBlackSet.prototype.removeSwapped = function(value,key){
		this.remove(key);
	};
	/**
	* @private
	*/
js_cols.RedBlackSet.prototype.min = function(x){
		while (x.left != this.sentinel){
			x = x.left;
		}
		return x;
	};
	/**
	* @private
	*/
	js_cols.RedBlackSet.prototype.max = function(x){
		while (x.right != this.sentinel){
			x = x.right;
		}
		return x;
	};
	/**
	 * Finds and returns the value associated with the succeeding key to that passed to the function
	 * @param {js_cols.RBnode} x 
	 * @return {js_cols.RBnode} the node with the succeeding key
	 * @private
	 */
js_cols.RedBlackSet.prototype.successor_ = function(x){
		if (x.right != this.sentinel) return this.min(x.right);
		var y = x.parent;
		while (y != this.sentinel && x==y.right){
			x = y;
			y = y.parent;
		}
		return y;
	};
	
	/**
	 * Finds and returns the value associated with the preceeding key to that passed to the function
	 * @param {js_cols.RBnode} x
	 * @return {js_cols.RBnode} the node with the preceeding key
	 * @private
	 */
	js_cols.RedBlackSet.prototype.predeccessor_ = function(x){
		
		if (x.left != this.sentinel) return this.max(x.left);
		var y = x.parent;
		while (y != this.sentinel && x==y.left){
			x = y;
			y = y.parent;
		}
		return y;
	};
	/**
	 * Finds and returns the value associated with the succeeding key to that passed to the function
	 * @param {*} key
	 * @return {*} the value associated with the succeeding key, or null if the supplied key was not in the set
	 * @public
	 */
	js_cols.RedBlackSet.prototype.successor = function(key){
		
		if(this.size >0){
		var x = this.get_(key);
		if (x == this.sentinel) return null;
		if (x.right != this.sentinel) return this.min(x.right).key;
		var y = x.parent;
		while (y != this.sentinel && x==y.right){
			x = y;
			y = y.parent;
		}
		if (y != this.sentinel)return y.key;
		else return null;
		}
		else {
		return null;
		}
	};
	/**
	 * Finds and returns the value associated with the preceeding key to that passed to the function
	 * @param {*} key
	 * @return {*} the value associated with the preceeding key, or null if the supplied key was not in the set
	 * @public
	 */
js_cols.RedBlackSet.prototype.predecessor = function(key){
		
		if(this.size >0){
		var x = this.get_(key);
		if (x == this.sentinel) return null;
		if (x.left != this.sentinel) return this.max(x.left).key;
		var y = x.parent;
		while (y != this.sentinel && x==y.left){
			x = y;
			y = y.parent;
		}
		if (y != this.sentinel)return y.key;
		else return null;
		}
		else {
		return null;
		}
	};
	
	/**
	 * Returns the value associated with the minimum key in this tree
	 * @return {*} the value associated with the minimum key in this tree 
	 * @public
	 */
	js_cols.RedBlackSet.prototype.getMin = function (){
	return this.min(this.root).key;
	};
	
	/**
	 * Returns the value associated with the maximum key in this tree
	 * @return {*} the value associated with the maximum key in this tree 
	 * @public
	 */
	js_cols.RedBlackSet.prototype.getMax = function (){
	return this.max(this.root).key;
	};
	
	/**
	* @param {*} key
	* @return {js_cols.RBnode} the node with the given key
	* @private
	*/
	js_cols.RedBlackSet.prototype.get_ = function(key){
		var x = this.root;
		while (x != this.sentinel && this.compare(x.key, key) != 0){
			if (this.compare(key, x.key)<0) x = x.left;
			else x= x.right;
		}
		return x;
	};

	
	/**
	 * Returns true if the key is associated with a value in this tree
	 * @param {*} key
	 * @return {Boolean} 
	 * @public
	 */
	js_cols.RedBlackSet.prototype.contains = function(key){
	return this.get_(key).key != null;
	};
	
	
	/**
 * Inserts the elements stored in the tree into a new Array and returns the Array.
 *
 * @return {Array} An array containing all of the trees elements in sorted order.
 */
js_cols.RedBlackSet.prototype.getValues = function() {
  var ret = [];
  this.forEach(function(x) {
    ret.push(x);
  });
  return ret;
};

/**
	 * Inserts a collection of values into the tree
	 * @param {*} element the value
	 * @public
	 */
	js_cols.RedBlackSet.prototype.insertAll = function(col){
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
	 * Removes a all values contained in the collection from the tree
	  * If the collection has a notion of keys (a Map), the keys will be
	 * treated as values in this set.
	 * @param {js_cols.Collection || Array || Object} col the collection of values to remove
	 * @public
	 */
	js_cols.RedBlackSet.prototype.removeAll = function(col){
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
	 * Checks that all values contained in the collection are also contained in the tree.
	 * Checks that all values contained in the collection are also contained in the tree.
	 * If the collection has a notion of keys (i.e. an Array or a Set), the keys of the collection
	 * will be interpreted as values in this set.
	 * @param {js_cols.Collection || Array || Object} col the collection of values to check
	 * @return {Boolean}
	 * @public
	 */
js_cols.RedBlackSet.prototype.containsAll = function(col){
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
	 * Returns an array of the values in a given key range in this tree. 
	 * The 'from' key is inclusive, the 'to' key exclusive
	 * @param {*} from the smallest key in the range
	 * @param {*} to the successor of the largest key in the range
	 * @return {Array} an array of values 
	 * @public
	 */

	js_cols.RedBlackSet.prototype.range = function(from, to){
		
		var retArray = [];
		this.traverseFromTo(function(x){
		retArray.push(x);
		}, from, to);
		return retArray;
		
	};
	
	/**
 * Performs an in-order traversal of the tree and calls {@code f} with each
 * traversed node. The traversal ends after traversing the tree's
 * maximum node or when {@code f} returns a value that evaluates to true.
 *
  * @param {Function} f The function to call for each item. The function takes
 *     two arguments: the key, and the RedBlackSet.
 * @param {Object=} opt_obj The object context to use as "this" for the
 *     function.
 * @public
 */	
js_cols.RedBlackSet.prototype.traverse =
    function(f, opt_obj ) {
    if (this.isEmpty()) return;
    var node = this.min(this.root);
  while (node != this.sentinel){
		
		if (f.call(opt_obj, node.key, this)) return;
		node = this.successor_(node);
		}
};

/**
 * Performs an in-order traversal of the tree and calls {@code f} with each
 * traversed node, starting on the node with a key = to
 * the specified start key. The traversal ends after traversing the tree's
 * maximum node or when {@code f} returns a value that evaluates to true.
 *
  * @param {Function} f The function to call for each item. The function takes
 *     two arguments: the key, and the RedBlackSet.
 * @param {Object=} fromKey Traversal will begin on the
 *    node with key = fromKey.
 * @param {Object=} opt_obj The object context to use as "this" for the
 *     function.
 * @public
 */
js_cols.RedBlackSet.prototype.traverseFrom =
    function(f, fromKey, opt_obj) {
    if (this.isEmpty()) return;
    var node = this.get_(fromKey);
  while (node != this.sentinel){
		
		if (f.call(opt_obj, node.key, this)) return;
		node = this.successor_(node);
		}
};

/**
 * Performs an in-order traversal of the tree and calls {@code f} with each
 * traversed node. The traversal ends before the node with key = toKey
 * or when {@code f} returns a value that evaluates to true.
 * @param {Function} f The function to call for each item. The function takes
 *     two arguments: the key, and the RedBlackSet.
 * @param {Object=} toKey Traversal will end before the
 *    node with the smallest key < toKey.
 * @param {Object=} opt_obj The object context to use as "this" for the
 *     function.
 * @public
 */
js_cols.RedBlackSet.prototype.traverseTo =
    function(f, toKey, opt_obj) {
    if (this.isEmpty()) return;
    var node = this.min(this.root);
    var toNode = this.get_(toKey);
  while (node != toNode){
		
		if (f.call(opt_obj, node.key, this)) return;
		node = this.successor_(node);
		}
};

/**
 * Performs an in-order traversal of the tree and calls {@code f} with each
 * traversed node, starting on the node with a key = to
 * the specified start key. The traversal ends before the node with key = toKey
 * or when {@code f} returns a value that evaluates to true.
 *
 * @param {Function} f The function to call for each item. The function takes
 *     two arguments: the key, and the RedBlackSet.
 * @param {Object=} fromKey Traversal will begin on the
 *    node with key = fromKey.
 * @param {Object=} toKey Traversal will end before the
 *    node with the smallest key < toKey.
 * @param {Object=} opt_obj The object context to use as "this" for the
 *     function.
 * @public
 */
js_cols.RedBlackSet.prototype.traverseFromTo =
    function(f,fromKey, toKey, opt_obj) {
    if (this.isEmpty()) return;
    var node = this.get_(fromKey);
    var toNode = this.get_(toKey);
  while (node != toNode){
		
		if (f.call(opt_obj, node.key, this)) return;
		node = this.successor_(node);
		}
};

/**
 * Performs a reverse-order traversal of the tree and calls {@code f} with
 * each traversed node, optionally starting from the largest node with a value
 * <= to the specified start value. The traversal ends after traversing the
 * tree's minimum node or when func returns a value that evaluates to true.
 *
  * @param {Function} f The function to call for each item. The function takes
 *     two arguments: the key, and the RedBlackSet.
 * @param {Object=} opt_obj The object context to use as "this" for the
 *     function.
 * @public
 */
js_cols.RedBlackSet.prototype.traverseBackwards =
    function(f, opt_obj) {
    if (this.isEmpty()) return;
    var node = this.max(this.root);
  while (node != this.sentinel){
		
		if (f.call(opt_obj, node.key, this)) return;
		node = this.predeccessor_(node);
		}
};

	/**
 * Calls a function on each item in the RedBlackSet.
 *
 * @param {Function} f The function to call for each item. The function takes
 *     two arguments: the key, and the RedBlackSet.
 * @param {Object=} opt_obj The object context to use as "this" for the
 *     function.
 */
js_cols.RedBlackSet.prototype.forEach = function(f, opt_obj) {
	if (this.isEmpty()) return;
  for (var n = this.min(this.root); n != this.sentinel; n = this.successor_(n)) {
  	
    f.call(opt_obj, n.key, n.key, this);
  }
};

/**
 * Calls a function on each item in the RedBlackSet and returns true if any of
 * those function calls returns a true-like value.
 *
 * @param {Function} f The function to call for each item. The function takes
 *     three arguments: the value, the key and the RedBlackSet, and returns a
 *     boolean.
 * @param {Object=} opt_obj The object context to use as "this" for the
 *     function.
 * @return {boolean} Whether f evaluates to true for at least one item in the
 *     RedBlackSet.
 */
js_cols.RedBlackSet.prototype.some = function(f, opt_obj) {
	if (this.isEmpty()) return false;
   for (var n = this.min(this.root); n != this.sentinel; n = this.successor_(n)) {
    if (f.call(opt_obj, n.key, n.key, this)) {
      return true;
    }
  }
  return false;
};


/**
 * Calls a function on each item in the RedBlackSet and returns true only if every
 * function call returns a true-like value.
 *
 * @param {Function} f The function to call for each item. The function takes
 *     three arguments: the value, the key and the RedBlackSet, and returns a
 *     boolean.
 * @param {Object=} opt_obj The object context to use as "this" for the
 *     function.
 * @return {boolean} Whether f evaluates to true for every item in the RedBlackSet.
 */
js_cols.RedBlackSet.prototype.every = function(f, opt_obj) {
	if (this.isEmpty()) return false;
  for (var n = this.min(this.root); n != this.sentinel; n = this.successor_(n)) {
    if (!f.call(opt_obj, n.key, n.key, this)) {
      return false;
    }
  }
  return true;
};

/**
 * Calls a function on each item in the RedBlackSet and returns the results of
 * those calls in an array.
 *
 * @param {!Function} f The function to call for each item. The function takes
 *     three arguments: the value, the key, and the RedBlackSet.
 * @param {Object=} opt_obj The object context to use as "this" for the
 *     function.
 * @return {!Array} The results of the function calls for each item in the
 *     RedBlackSet.
 */
js_cols.RedBlackSet.prototype.map = function(f, opt_obj) {
  var rv = [];
  if (this.isEmpty()) return rv;
  for (var n = this.min(this.root); n != this.sentinel; n = this.successor_(n)) {
    rv.push(f.call(opt_obj, n.key, n.key, this));
  }
  return rv;
};

/**
 * Calls a function on each item in the RedBlackSet, if the function returns true, the key/value pair
 * is inserted into an object that is returned when the tree is fully traversed
 *
 * @param {!Function} f The function to call for each item. The function takes
 *     three arguments: the value, the key, and the RedBlackSet.
 * @param {Object=} opt_obj The object context to use as "this" for the
 *     function.
 * @return {!Array} The key / value pairs that evaluated to true in the function calls for each item in the
 *     RedBlackSet.
 */
js_cols.RedBlackSet.prototype.filter = function(f, opt_obj) {
  var rv = [];
  if (this.isEmpty()) return rv;
  for (var n = this.min(this.root); n != this.sentinel; n = this.successor_(n)) {
    if (f.call(opt_obj, n.key, n.key, this)) {
    	rv.push(n.key);
    }
  }
  return rv;
};

/**
	 * Returns the current size of the tree (number of elements)
	 * @return {Integer} 
	 * @public
	 */

js_cols.RedBlackSet.prototype.getCount = function(){
		return this.size;
	};
	
	/**
	 * Returns true if the current size of the tree is zero
	 * @return {Boolean} 
	 * @public
	 */

	js_cols.RedBlackSet.prototype.isEmpty = function(){
		return this.size ==0;
	};
	
		/**
 * Tests whether the given collection contains all the elements in this set.
  * WARNING: This operation is not guaranteed to work correctly if col is a Map.
 * Primitives are treated as equal if they have the same type and convert to the
 * same string; objects are treated as equal if they are references to the same
 * object.  
  * This operation is O(n * O(col.contains)).
 * Example: if col is another RedBlackSet of size m, running time is O(n log(m)),
 * if col is an Array or LinkedList, running time is O(n * m),
 * if col is a HashSet, running time is O(n).
 * @param {js_cols.Set|Array|Object} col A collection.
 * @return {boolean} True if this set is a subset of the given collection.
 */
js_cols.RedBlackSet.prototype.isSubsetOf = function(col) {
  var colCount = js_cols.getCount(col);
  if (this.getCount() > colCount) {
    return false;
  }
    var i =0;
  if (this.isEmpty()) return true;
  
  for (var n = this.min(this.root); n != this.sentinel; n = this.successor_(n)) {
    if (js_cols.contains.call(col, col, n.key)) {
    	i++;
    }
  }
  return i == this.getCount();
};

/**
 * Finds all values that are present in both this set and the given collection.
 * This operation is O(n * O(col.contains)).
  * WARNING: This operation is not guaranteed to work correctly if col is a Map.
 * Example: if col is another RedBlackSet of size m, running time is O(n log(m)),
 * if col is an Array or LinkedList, running time is O(n * m),
 * if col is a HashSet, running time is O(n).
 * @param {js_cols.Set|Array|Object} col A collection.
 * @return {js_cols.Set} A new set containing all the values (primitives
 *     or objects) present in both this set and the given collection.
 */
js_cols.RedBlackSet.prototype.intersection = function(col) {
	var  result = new js_cols.RedBlackSet(this.compare);
	if (this.isEmpty()) return result;
  for (var n = this.min(this.root); n != this.sentinel; n = this.successor_(n)) {
    if (col.contains.call(col, n.key, n.key, this)) {
    	result.insert(n.key);
    }
  }
  return result;
};
	

