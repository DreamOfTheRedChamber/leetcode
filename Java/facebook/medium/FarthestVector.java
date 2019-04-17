package facebook.medium;

/**
 * 给n个d维的vector和一个first selected的vector, 选出k个vector,每次选择下一个时要求：选离所有selected vector最远的vector, 
 * 计算距离的函数已给出D(v1,v2)并假设调用此函数时间复杂度为O(1), 
 * 某vector与所有selected vectors的距离定义为这个vector与其nearest selected neighbor的距离。
 * 在面试官的提示下最终找到了复杂度为O(nk)的最优解，对每个unselected的vector存下其与selected vectosr的距离,
 * 每次遍历unselected vectors找出距离最远的vector为下一个selected vector, 
 * 用这个vector与每个unselected vector的距离去更新距离（若小于原距离，表示nearest selected neighbor更换了）  
 */

public class FarthestVector
{

}
