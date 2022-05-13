import java.lang.NullPointerException;
import java.lang.IllegalArgumentException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class HotelReservation {

    private GuestType guestType = GuestType.REWARDS;
    private int counterWeekdays = 0;
    private int counterWeekendDays = 0;
    private final ArrayList<Hotel> hotels = new ArrayList<>();

    public String getCheapestHotel(String input) {

        validateInput(input);

        hotels.add(new Hotel("Lakewood", 3, 110, 80, 90, 80));
        hotels.add(new Hotel("Bridgewood", 4, 160, 110, 60, 50));
        hotels.add(new Hotel("Ridgewood", 5, 220, 100, 150, 40));

        return selectCheapestHotel();
    }


    private String selectCheapestHotel() {

        int positionOfCheapestHotel = 0;
        float priceOfCheapestHotel = hotels.get(0).getPriceWeekdays(guestType) * counterWeekdays +
                hotels.get(0).getPriceWeekend(guestType) * counterWeekendDays;

        for (int i = 1; i < hotels.size(); i++) {
            float priceOfCandidateHotel = hotels.get(i).getPriceWeekdays(guestType) * counterWeekdays +
                    hotels.get(i).getPriceWeekend(guestType) * counterWeekendDays;
            if (priceOfCheapestHotel > priceOfCandidateHotel) {
                priceOfCheapestHotel = priceOfCandidateHotel;
                positionOfCheapestHotel = i;
            } else if (priceOfCheapestHotel == priceOfCandidateHotel) {
                if(hotels.get(i).getRate()>hotels.get(positionOfCheapestHotel).getRate()){
                    priceOfCheapestHotel = priceOfCandidateHotel;
                    positionOfCheapestHotel = i;
                }
            }
        }

        return hotels.get(positionOfCheapestHotel).getName();
    }

    private void validateInput(String input) {
        if (input.trim().equals("")) {
            throw new NullPointerException();
        }

        validateInputSyntax(input);
    }


    private void validateInputSyntax(String input) {
        if (input.charAt(7) == ':') {
            String[] guestTypeAndDates = input.split(":", 2);
            validateGuestType(guestTypeAndDates[0]);
            validateDates(guestTypeAndDates[1]);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void validateDates(String datesString) {

        SimpleDateFormat dateFormat3LettersDayOfWeek = new SimpleDateFormat(" ddMMMyyyy(EEE)", Locale.US);

        String[] dates = datesString.split(",");

        for (int i = 0; i < dates.length; i++) {

            if(dates[i].substring(11,15).equalsIgnoreCase("tues") ||
               dates[i].substring(11,15).equalsIgnoreCase("thur")){
                dates[i]=dates[i].substring(0,14)+dates[i].charAt(dates[i].length()-1);
            }

            try {
                dateFormat3LettersDayOfWeek.parse(dates[i]);
            } catch (ParseException parseException3) {
                throw new IllegalArgumentException("Invalid date in position " + i + "");
            }

            switch (dates[i].substring(11,13)) {
                case "mo":
                case "tu":
                case "we":
                case "th":
                case "fr":
                    counterWeekdays++;
                    break;
                case "sa":
                case "su":
                    counterWeekendDays++;
                    break;
            }
        }
    }

    private void validateGuestType(String input) {
        if (input.equalsIgnoreCase(GuestType.REGULAR.toString())) {
            guestType = GuestType.REGULAR;
        } else if (input.equalsIgnoreCase(GuestType.REWARDS.toString())) {
            guestType = GuestType.REWARDS;
        } else {
            throw new java.lang.IllegalArgumentException("Argument before colon (:) is not a Guest Type");
        }
    }
}