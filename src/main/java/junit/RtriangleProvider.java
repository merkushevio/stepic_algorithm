package junit;

public final class RtriangleProvider {
    public static Rtriangle getRtriangle() {
        Rtriangle rtriangle = new Rtriangle() {
            public int getApexX1() {
                return -5;
            }

            public int getApexY1() {
                return -2;
            }

            public int getApexX2() {
                return 5;
            }

            public int getApexY2() {
                return 7;
            }

            public int getApexX3() {
                return 2;
            }

            public int getApexY3() {
                return -2;
            }
        };
        return rtriangle;
    }
}