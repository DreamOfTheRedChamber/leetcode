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
js_cols.require('js_cols.RedBlackSet');
 js_cols.require('js_cols.RBnode');
  js_cols.provide('js_cols.RedBlackBag');
/**
 *
 * 
 *
 * js_cols.RedBlackBag provides the implementation of a Red Black Tree multiset datastructure. The tree
 * maintains a set of values in sorted order. A MultiSet allows dublicates. In case of dublicate values, 
 * the most recently inserted will be deleted when calling remove. The range function can be used to retrieve
 * all equal values. The values can be
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
 * @public
 * @see js_cols.RedBlackSet
 * @constructor
 * @extends js_cols.RedBlackSet
 */


 
js_cols.RedBlackBag = function(compare_func){
js_cols.RedBlackSet.call(this,compare_func);

};

js_cols.inherits(js_cols.RedBlackBag, js_cols.RedBlackSet);

	/**
	* alternative insert function for multiple entries of same key
	* @param {*} key the keyto insert
	* @private
	*/
		js_cols.RedBlackBag.prototype.insert = function(key){
	
		
		
		var z = new js_cols.RBnode(this);
		z.key = key;
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
	* @param {*} key
	* @return {js_cols.RBnode} the node with the given key
	* @private
	*/
	js_cols.RedBlackBag.prototype.get_ = function(key){
		var x = this.root;
		while (x != this.sentinel && this.compare(x.key, key) != 0){
			if (this.compare(key, x.key)<0) x = x.left;
			else x= x.right;
		}
		while (x != this.sentinel && x.left != this.sentinel && this.compare(x.left.key, key) ==0) {
		x = x.left;
		}
		return x;
	}
	
	/**
	 * Overriding RedBlackSets clone method.
	 * Clones a set and returns a new set.
	 * @return {!js_cols.RedBlackBag} A new map with the same key-value pairs.
	 */
	js_cols.RedBlackBag.prototype.clone = function(){
		var rv = new js_cols.RedBlackBag(this.compare);
		rv.insertAll(this);
		return rv;

	};
	

