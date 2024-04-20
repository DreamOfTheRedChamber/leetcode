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
js_cols.require('js_cols.RedBlackMap');
 js_cols.require('js_cols.RBnode');
 js_cols.provide('js_cols.RedBlackMultiMap');
/**
 * 
 *
 *
 * js_cols.RedBlackMultiMap provides the implementation of a Red Black Tree multi map datastructure. The tree
 * maintains a set of values, sorted by their corresponding keys. A MultiMap allows key dublicates. In case of dublicate keys, 
 * the most recently inserted will be deleted when calling remove. The range function can be used to retrieve
 * all values, mapped to a single key. Sample usage:
 * <pre>
 * var mm = new js_cols.ABTreeMultiMap();
 * mm.insert('a', 'apple');
 * mm.insert('a', 'almond');
 * mm.insert('a', 'anaconda');
 * var aValues = mm.range('a','b'); // returns ['apple', 'almond', 'anaconda']
 * </pre> 
 * The key/value pairs can be inserted and deleted efficiently 
 * in their sorted order as the tree enforces a log(n)
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
 * @see js_cols.RedBlackMap
 * @constructor
 * @extends js_cols.RedBlackMap
 */

js_cols.RedBlackMultiMap = function(compare_func){
js_cols.RedBlackMap.call(this, compare_func);
};

js_cols.inherits(js_cols.RedBlackMultiMap, js_cols.RedBlackMap);

	// changing addToLeafs to allow multiple entries for same key
	 /**
	 * Inserts a key/value pair into the tree
	 * @param {*} key the key used for ordering and location
	 * @param {*} element the value associated with the key
	 * @public
	 */
	js_cols.RedBlackMultiMap.prototype.insert = function(key, value){
	
		
		
		var z = new js_cols.RBnode(this);
		z.key = key;
		z.value = value;
		var y = this.sentinel;
		var x = this.root;
		while (x != this.sentinel){
			y=x;
			//if (z.key < x.key) x = x.left;
			if (this.compare(z.key, x.key)<0) x = x.left;
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
		
	};
	
	
	/**
	* A version of this.get_ modified to handle multiple entries for same key in correct order
	* @return {js_cols.RBnode} the node with the given key
	* @private
	*/
js_cols.RedBlackMultiMap.prototype.get_ = function(key){
		var x = this.root;
		while (x != this.sentinel && this.compare(x.key, key) != 0){
			if (this.compare(key, x.key)<0) x = x.left;
			else x= x.right;
		}
		
		while (x != this.sentinel && x.left != this.sentinel && this.compare(x.left.key, key) ==0) {
		x = x.left;
		}
		
		return x;
	};
	
	/**
	 * Overriding RedBlackMaps clone method.
	 * Clones a set and returns a new set.
	 * @return {!js_cols.RedBlackMultiMap} A new map with the same key-value pairs.
	 */
js_cols.RedBlackMultiMap.prototype.clone = function(){
		var rv = new js_cols.RedBlackMultiMap(this.compare);
		rv.insertAll(this);
		return rv;
	
	};
	
	/**
	 * this opreation is not supported by Multi Maps
	 */
js_cols.RedBlackMultiMap.prototype.isSubmapOf = undefined; 
	
	/**
	 * this opreation is not supported by Multi Maps
	 */
js_cols.RedBlackMultiMap.prototype.intersection = undefined;
