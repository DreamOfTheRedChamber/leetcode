import { ContainerIterator, IteratorType } from '@/container/ContainerBase';
import SequentialContainer from '@/container/SequentialContainer/Base/index';
import { throwIteratorAccessError } from '@/utils/throwError';

export abstract class RandomIterator<T> extends ContainerIterator<T> {
  abstract readonly container: SequentialContainer<T>;
  /**
   * @internal
   */
  _node: number;
  /**
   * @internal
   */
  protected constructor(
    index: number,
    iteratorType?: IteratorType
  ) {
    super(iteratorType);
    this._node = index;
    if (this.iteratorType === IteratorType.NORMAL) {
      this.pre = function () {
        if (this._node === 0) {
          throwIteratorAccessError();
        }
        this._node -= 1;
        return this;
      };
      this.next = function () {
        if (this._node === this.container.size()) {
          throwIteratorAccessError();
        }
        this._node += 1;
        return this;
      };
    } else {
      this.pre = function () {
        if (this._node === this.container.size() - 1) {
          throwIteratorAccessError();
        }
        this._node += 1;
        return this;
      };
      this.next = function () {
        if (this._node === -1) {
          throwIteratorAccessError();
        }
        this._node -= 1;
        return this;
      };
    }
  }
  get pointer() {
    return this.container.getElementByPos(this._node);
  }
  set pointer(newValue: T) {
    this.container.setElementByPos(this._node, newValue);
  }
  isAccessible() {
    return this._node !== this.container.size();
  }
  // @ts-ignore
  pre(): this;
  // @ts-ignore
  next(): this;
}
