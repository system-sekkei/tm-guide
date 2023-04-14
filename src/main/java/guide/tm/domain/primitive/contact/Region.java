package guide.tm.domain.primitive.contact;

/**
 * 地域
 */
public enum Region {
    北海道,
    東北,
    関東,
    中部,
    近畿,
    中国,
    四国,
    九州,
    ;

    public int distanceFrom(Region other) {
        return switch (this) {
            case 北海道 -> switch (other) {
                case 北海道 -> 0;
                case 東北 -> 1;
                case 関東 -> 2;
                case 中部 -> 3;
                case 近畿 -> 4;
                case 中国 -> 5;
                case 四国 -> 6;
                case 九州 -> 7;
            };
            case 東北 -> switch (other) {
                case 北海道 -> 1;
                case 東北 -> 0;
                case 関東 -> 1;
                case 中部 -> 2;
                case 近畿 -> 3;
                case 中国 -> 4;
                case 四国 -> 5;
                case 九州 -> 6;
            };
            case 関東 -> switch (other) {
                case 北海道 -> 2;
                case 東北 -> 1;
                case 関東 -> 0;
                case 中部 -> 1;
                case 近畿 -> 2;
                case 中国 -> 3;
                case 四国 -> 4;
                case 九州 -> 5;
            };
            case 中部 -> switch (other) {
                case 北海道 -> 3;
                case 東北 -> 2;
                case 関東 -> 1;
                case 中部 -> 0;
                case 近畿 -> 1;
                case 中国 -> 2;
                case 四国 -> 3;
                case 九州 -> 4;
            };
            case 近畿 -> switch (other) {
                case 北海道 -> 4;
                case 東北 -> 3;
                case 関東 -> 2;
                case 中部 -> 1;
                case 近畿 -> 0;
                case 中国 -> 1;
                case 四国 -> 2;
                case 九州 -> 3;
            };
            case 中国 -> switch (other) {
                case 北海道 -> 5;
                case 東北 -> 4;
                case 関東 -> 3;
                case 中部 -> 2;
                case 近畿 -> 1;
                case 中国 -> 0;
                case 四国 -> 1;
                case 九州 -> 2;
            };
            case 四国 -> switch (other) {
                case 北海道 -> 6;
                case 東北 -> 5;
                case 関東 -> 4;
                case 中部 -> 3;
                case 近畿 -> 2;
                case 中国 -> 1;
                case 四国 -> 0;
                case 九州 -> 1;
            };
            case 九州 -> switch (other) {
                case 北海道 -> 7;
                case 東北 -> 6;
                case 関東 -> 5;
                case 中部 -> 4;
                case 近畿 -> 3;
                case 中国 -> 2;
                case 四国 -> 1;
                case 九州 -> 0;
            };
        };
    }
}
