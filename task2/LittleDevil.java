package W02.task2;

public class LittleDevil extends Item {
    @Override
    public int getRank() {
        return ColorMap.getRank(color);
    }

    @Override
    public String toString() {
        // 为了效果更加美观，对输出的空格进行了限制处理
        int rank = this.getRank();
        String spaceRank = "";
        if (rank / 10 != 0) {
            spaceRank = " " + rank + " ";
        } else {
            spaceRank = "  " + rank + " ";
        }
        return "\033[48;2;" + this.color + ";38;2;0;0;0m" + spaceRank + "\033[0m";
    }

    public void setColor(String color) {
        this.color = color;
    }
}
