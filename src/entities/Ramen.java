package entities;

import java.io.Serializable;

/**
 * Entity class of ramen
 */
public class Ramen implements Serializable {
    /**
     * Attribute of ramen
     */
    private static final long serialVersionUID = 1L;
    private String soup = "Tonkosu";
    private String noodles="Soft";
    private int onion_level = 0;//0: No, 1: A little, 2: A lot
    private Boolean nori = false;
    private Boolean chashu = false;
    private Boolean boiled_egg = false;
    private int spiciness = 0;//0:no,1,2,3,4,5(max)
    public int ramenNumber = 1; //这种面的数量

    private int extra_nori = 0;//多加多少紫菜，默认0，可以1-10或者1-99，99非常能吃
    private int extra_boiled_egg = 0;//多加多少鸡蛋
    private int Bamboo_shoots = 0;//多加多少竹笋
    private int extra_chashu= 0;//多加多少叉烧

    private static float NoriPrice = 1f;  //add-on的单价
    private static float BoiledEggPrice = 1f;
    private static float BambooShootPrice = 1f;
    private static float ChashuPrice = 2f;
    private static float fixPrice = 9.9f;

     public Ramen() {
         fixPrice = Menu.getFixed_price();
         NoriPrice = Menu.getP_E_Nori();
         BoiledEggPrice = Menu.getP_E_boiledEgg();
         BambooShootPrice = Menu.getP_Bamboo_Shoots();
         ChashuPrice = Menu.getP_E_Chashu();
     }

    //get methods
    public String getSoup() {
        return soup;
    }

    public String getNoodles() {
        return noodles;
    }

    public int getOnion_level() {
        return onion_level;
    }

    public Boolean getNori() {
        return nori;
    }

    public Boolean getChashu() {
        return chashu;
    }

    public Boolean getBoiled_egg() {
        return boiled_egg;
    }

    public int getSpiciness() {
        return spiciness;
    }

    public int getNum() { return this.ramenNumber; }

    //get methods for add-ons
    public int getExtra_nori() {
        return extra_nori;
    }

    public int getExtra_boiled_egg() {
        return extra_boiled_egg;
    }

    public int getExtra_chashu() {
        return extra_chashu;
    }

    public int getBamboo_shoots() {
        return Bamboo_shoots;
    }

   //set methods
    public void setSoup(String soup) {
        this.soup = soup;
    }

    public void setNoodles(String noodles) {
        this.noodles = noodles;
    }

    public void setOnion_level(int onion_level) {
        this.onion_level = onion_level;
    }

    public void setNori(Boolean nori) {
        this.nori = nori;
    }

    public void setChashu(Boolean chashu) {
        this.chashu = chashu;
    }

    public void setBoiled_egg(Boolean boiled_egg) {
        this.boiled_egg = boiled_egg;
    }

    public void setSpiciness(int spiciness) {
        this.spiciness = spiciness;
    }

    public void setNum(int ramenNumber) {
        this.ramenNumber = ramenNumber;
    }

    //add-ons
    public void setExtra_nori(int extra_nori) {
        this.extra_nori = extra_nori;
    }

    public void setExtra_boiled_egg(int extra_boiled_egg) {
        this.extra_boiled_egg = extra_boiled_egg;
    }

    public void setBamboo_shoots(int bamboo_shoots) {
        Bamboo_shoots = bamboo_shoots;
    }

    public void setExtra_chashu(int extra_chashu) {
        this.extra_chashu = extra_chashu;
    }

    //add-on Amount
    public static void setNoriPrice(float noriPrice) {
        NoriPrice = noriPrice;
    }

    public static void setChashuPrice(float chashuPrice) {
        ChashuPrice = chashuPrice;
    }

    public static void setBoiledEggPrice(float boiledEggPrice) {
        BoiledEggPrice = boiledEggPrice;
    }

    public static void setBambooShootPrice(float bambooShootPrice) {
        BambooShootPrice = bambooShootPrice;
    }

    public float getNoriAmount() {
        return NoriPrice * this.extra_nori;
    }

    public float getBoiledEggAmount() {
        return BoiledEggPrice * this.extra_boiled_egg;
    }

    public float getChashuAmount() {
        return ChashuPrice * this.extra_chashu;
    }

    public float getBambooShootAmount() {
        return BambooShootPrice * this.Bamboo_shoots;
    }

    public float calcRamenAmount() {
        float RamenAmount = fixPrice;
        RamenAmount += this.getNoriAmount();
        RamenAmount += this.getBoiledEggAmount();
        RamenAmount += this.getBambooShootAmount();
        RamenAmount += this.getChashuAmount();
        return RamenAmount;
    }
}
