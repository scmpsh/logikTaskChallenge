public class LogicTasks {
    public static void main(String[] args) {
//        for (int i = 0; i < 1000; i++) {
        GeneratedData generatedBoxesInfo = getTwelveBoxesWithOneNonNormalBox();
        int position = getNonNormalBox(generatedBoxesInfo.getRandomBoxes());
//            if (!(position == generatedBoxesInfo.getCorrectBoxPosition())) {
        System.out.println(position == generatedBoxesInfo.getCorrectBoxPosition());
//        System.out.println("counter = " + Box.getCounter());
//            }
//        }
    }

    /* Входные параметры для примера теста
     * тут всегда отличается 7 коробка */
    private static GeneratedData getTwelveBoxesWithOneNonNormalBox() {
        Box[] randomBoxes = new Box[12];

        int pos = (int) (Math.random() * 12);
//        int pos = 11;
//        System.out.println("pos = " + pos);
        for (int i = 0; i < 12; i++) {
            randomBoxes[i] = new Box(-5);
        }
        randomBoxes[pos] = new Box(0);
        return new GeneratedData(randomBoxes, pos);
    }

    /* Ваша задача - реализовать этот метод.
       getNonNormalBox должен вернуть позицию коробки в массиве, отличающейся по value от остальных одинаковых коробок.
     */
    private static int getNonNormalBox(Box[] boxes) {
        int i;
        int j;

        i = 5;
        j = 6;

        while (i >= 0 && j <= 11) {
            if (Box.comparing(boxes[i], boxes[j]) != 0) {
                if (i != 0) {
                    if (Box.comparing(boxes[i], boxes[i - 1]) != 0) {
                        return i;
                    } else {
                        return j;
                    }
                } else {
                    if (Box.comparing(boxes[0], boxes[i + 1]) != 0) {
                        return 0;
                    } else {
                        return 11;
                    }
                }
            }
            i--;
            j++;
        }
        return 0;
    }
}

