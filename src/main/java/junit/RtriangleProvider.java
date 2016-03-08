package junit;

public final class RtriangleProvider {
    public static Rtriangle getRtriangle() {
        Rtriangle rtriangle = new Rtriangle() {
            public int getApexX1() {
                return 1;
            }

            public int getApexY1() {
                return 1;
            }

            public int getApexX2() {
                return 3;
            }

            public int getApexY2() {
                return 1;
            }

            public int getApexX3() {
                return 4;
            }

            public int getApexY3() {
                return 3;
            }
        };
        return rtriangle;
    }
}