public class LogicTasks {
    public static void main(String[] args) {
//        for (int i = 0; i < 12; i++) {
            GeneratedData generatedBoxesInfo = getTwelveBoxesWithOneNonNormalBox();
            int position = getNonNormalBox(generatedBoxesInfo.getRandomBoxes());
//            if (!(position == generatedBoxesInfo.getCorrectBoxPosition())) {
                System.out.println(position == generatedBoxesInfo.getCorrectBoxPosition());
//            }
//        }
    }

    /* Входные параметры для примера теста
     * тут всегда отличается 7 коробка */
    private static GeneratedData getTwelveBoxesWithOneNonNormalBox() {
        Box[] randomBoxes = new Box[12];

        int pos = (int) (Math.random() * 12);
//        System.out.println(pos);
        for (int i = 0; i < 12; i++) {
            randomBoxes[i] = new Box(5);
        }
        randomBoxes[pos] = new Box(0);
        return new GeneratedData(randomBoxes, pos);
    }

    /* Ваша задача - реализовать этот метод.
       getNonNormalBox должен вернуть позицию коробки в массиве, отличающейся по value от остальных одинаковых коробок.
     */
    private static int getNonNormalBox(Box[] boxes) {
        int j;
        int position;
        Box tmpBox1, tmpBox2;

        j = boxes.length - 1;
        position = 0;
        tmpBox1 = boxes[0];
        tmpBox2 = boxes[j];
        for (int i = 0; i < boxes.length; ) {
            if (Box.comparing(boxes[i], boxes[j]) != 0) {
                if (Box.comparing(tmpBox1, boxes[i]) != 0) {
                    position = i;
                    break;
                } else if (Box.comparing(tmpBox2, boxes[j]) != 0) {
                    position = j;
                    break;
                }
            }
            tmpBox1 = boxes[i];
            tmpBox2 = boxes[j];
            j--;
            i++;
        }
        return position;
    }
}

