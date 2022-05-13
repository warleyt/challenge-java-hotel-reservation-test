import java.math.BigDecimal;

public class Hotel {

    private String name;
    private int rate;
    private float priceWeekdaysRegular;
    private float priceWeekdaysRewards;
    private float priceWeekendRegular;
    private float priceWeekendRewards;


    public Hotel(String name, int rate,
                 float priceWeekdaysRegular, float priceWeekdaysRewards,
                 float priceWeekendRegular, float priceWeekendRewards) {

        this.name = name;
        this.rate = rate;
        this.priceWeekdaysRegular = priceWeekdaysRegular;
        this.priceWeekdaysRewards = priceWeekdaysRewards;
        this.priceWeekendRegular = priceWeekendRegular;
        this.priceWeekendRewards = priceWeekendRewards;
    }

    public float getPriceWeekdays(GuestType guestType) {
        if (guestType.toString().equalsIgnoreCase(GuestType.REGULAR.toString())) {
            return priceWeekdaysRegular;
        } else {
            return priceWeekdaysRewards;
        }
    }

    public float getPriceWeekend(GuestType guestType) {
        if (guestType.toString().equalsIgnoreCase(GuestType.REGULAR.toString())) {
            return priceWeekendRegular;
        } else {
            return priceWeekendRewards;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public float getPriceWeekendRegular() {
        return priceWeekendRegular;
    }

    public void setPriceWeekendRegular(float priceWeekendRegular) {
        this.priceWeekendRegular = priceWeekendRegular;
    }

    public float getPriceWeekdaysRegular() {
        return priceWeekdaysRegular;
    }

    public void setPriceWeekdaysRegular(float priceWeekdaysRegular) {
        this.priceWeekdaysRegular = priceWeekdaysRegular;
    }

    public float getPriceWeekendRewards() {
        return priceWeekendRewards;
    }

    public void setPriceWeekendRewards(float priceWeekendRewards) {
        this.priceWeekendRewards = priceWeekendRewards;
    }

    public float getPriceWeekdaysRewards() {
        return priceWeekdaysRewards;
    }

    public void setPriceWeekdaysRewards(float priceWeekdaysRewards) {
        this.priceWeekdaysRewards = priceWeekdaysRewards;
    }
}
