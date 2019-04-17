def main():
    array = [1, 2, 3, 4, 5]
    print array[2]

def totalFruit(fruitTypes):
    maxNumOfFruits = 0
    for fruitTypeOneIndex in range(0, input.__len__()):
        numOfFruits = 1
        fruitTypeOne = fruitTypes[fruitTypeOneIndex]
        fruitTypeTwo = -1
        for nextFruit in range(fruitTypeOne, input.__len__()):
            if fruitTypes[nextFruit] != fruitTypeOne and fruitTypeTwo == -1:
                fruitTypeTwo = nextFruit
                numOfFruits += 1
            elif fruitTypes[nextFruit] != fruitTypeOne and (fruitTypeTwo != -1 and fruitTypes[nextFruit] != fruitTypeTwo):
                break
            elif fruitTypes[nextFruit] == fruitTypeOne or fruitTypes[nextFruit] == fruitTypeTwo:
                numOfFruits += 1
            if numOfFruits > maxNumOfFruits:
                maxNumOfFruits = numOfFruits
    return maxNumOfFruits

array = [1, 2, 3, 4, 5]
print totalFruit(array)
