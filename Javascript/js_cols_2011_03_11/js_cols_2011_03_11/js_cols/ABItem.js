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
js_cols.provide('js_cols.ABItem');
/**
 * An ABItem is a node containing pointers to between a and b children,
 * with corresponding splitter keys
 * @param {Array} c an array of child-pointers
 * @param {Array} s an array of splitters
 * @param {js_cols.ABTreeSet} tree the tree that holds this ABitem
 * @constructor
 * @private 
 */

js_cols.ABItem = function (c,s, tree){
	
	/**
	 * Array of splitter keys
	 * @type {Array}
	 * @private
	 */
	this.splitters = s;
	/**
	 * Array of pointers to children (ABItems or LeafNodes)
	 * @type {Array}
	 * @private
	 */
	this.children =c;
	/**
	 * Reference to the tree that holds this ABItem
	 * @type {js_cols.ABTreeSet}
	 * @private
	 */
	this.tree = tree;
	
	};

	/**
	 * Locating the position of a child based on the splitter keys, internally in an ABItem
	 * @param {*} key the key to look for
	 * @return {Integer} the index of the child node with key(s) less than key, or index of last child if it´s key(s) is/are larger than key
	 * @private
	 */	
	js_cols.ABItem.prototype.locateLocally = function(key){
	
		return this.tree.locateLocally(key, this.splitters);
		
	};
	
	/**
	 * Recursive helper function to locate a given key. Recursion stops when h==1 (the leafs are reached)
	 * @param {*} key the key to look for
	 * @param {Integer} h the current height we are looking at
	 * @return {*} the element with the key closest to k 
	 * @private
	 */	
	js_cols.ABItem.prototype.locateRec = function(k, h){
		var i = this.locateLocally(k);
		// when h == 1 a leaf is reached and last recursive call returns a node of the list
		if (h == 1) {
			if (this.tree.compare(this.children[i].key, k) <= 0) {return this.children[i];}
			else {return this.children[i].next;}
		}
		else return this.children[i].locateRec(k, h-1);
	};

	/**
	 * Recursive helper function to insert a given key/value pair. Recursion stops when h==1 (the leafs are reached)
	 * @param {*} key the key to guide the insertion 
	 * @param {*} element the value associated with the key
	 * @param {Integer} h the current height we are looking at
	 * @private
	 */	
	js_cols.ABItem.prototype.insertRec = function(k, element, h){
		var i = this.locateLocally(k);
		// base case 
		//var t;
		if (h == 1){
		var t = this.tree.addToLeafs(this.children[i], k, element);
		if (t == null) return t;
		
		}

		else {


			var t = this.children[i].insertRec (k, element, h-1);

			if (t == null) return null;
		}



		this.splitters.splice(i,0,t.k);

		if (h > 1 || this.tree.compare( this.children[i].key , t.k)>0){

			this.children.splice(i,0,t.handle);

		}
		else{
			this.children.splice(i+1,0,t.handle);

		}


		if (this.children.length <=this.tree.b){


			return null;

		}
		else{

			var m = Math.floor(this.tree.b/2);
			var tSplitters = this.splitters.slice(0,m-1);
			var tChildren = this.children.slice(0,m);
			var splt = this.splitters[m-1];
			this.splitters = this.splitters.slice(m);
			this.children = this.children.slice(m);
			var newItem = new js_cols.ABItem(tChildren, tSplitters, this.tree);


			return {
				"k": splt,
				"handle": newItem
			};

		}
	};

	/**
	 * Removing a splitter and a child pointer at a given index in a ABItem
	 * @param {Integer} i the position to remove
	 * @private
	 */	
	js_cols.ABItem.prototype.removeLocally = function( i){

		if (i != this.children.length-1){
			this.splitters.splice(i,1);
			this.children.splice(i,1);

		}
		else{

			this.splitters.splice(i-1,1);
			this.children.splice(i,1);

		}


	};

	/**
	 * Recursive helper function to remove a given key/value pair. Recursion stops when h==1 (the leafs are reached)
	 * @param {*} k the key to remove 
	 * @param {Integer} h the current height we are looking at
	 * @private
	 */	
	js_cols.ABItem.prototype.removeRec = function(k, h){

		var i = this.locateLocally(k);

		// base case 

		if (h == 1){
			var leaf = this.children[i];
			if (this.tree.compare(leaf.key, k)==0) {
				this.tree.removeElement(leaf, this, i);
				/*
				this.tree.LeafList.removeFromList(leaf);
				this.removeLocally(i);
				*/
			}

		}

		else{
			var hdl = this.children[i];
			hdl.removeRec(k, h-1);



			if (hdl.children.length < this.tree.a){
				if (i== this.children.length -1) i--;
				var rightSibling = this.children[i+1];

				this.children[i].splitters.push(this.splitters[i]);
				rightSibling.splitters = this.children[i].splitters.concat(rightSibling.splitters);
				rightSibling.children = this.children[i].children.concat(rightSibling.children);


				if (rightSibling.children.length <= this.tree.b){  // fuse items



					this.removeLocally(i);

				}
				else{ // balance items
					var m = Math.floor((rightSibling.children.length-1)/2);
					this.children[i].splitters = rightSibling.splitters.slice(0,m-1);
					this.children[i].children = rightSibling.children.slice(0,m);
					this.splitters[i] = rightSibling.splitters[m-1];

					rightSibling.splitters = rightSibling.splitters.slice(m);
					rightSibling.children = rightSibling.children.slice(m);


				}


			}
		}

	};



