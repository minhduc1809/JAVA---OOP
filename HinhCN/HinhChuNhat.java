package HInhCN;

public class HinhChuNhat {
    static class Rectangle {
        private int width;
        private int height;

        public Rectangle(int width, int height) {
            Set(width,height);
        }
        public int calculatePerimeter() {
            return 2 * (width + height);
        }

        public int calculateArea() {
            return width * height;
        }
        public void Set(int width, int height){
            if (width <= 0 || height <= 0) {
                throw new IllegalArgumentException("Chiều dài và chiều rộng phải là số nguyên dương.");
            }
            this.width = width;
            this.height = height;
        }
    }
}
