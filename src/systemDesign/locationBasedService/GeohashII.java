package systemDesign.locationBasedService;

/*
This is a followup question for Geohash.

Convert a Geohash string to latitude and longitude.

Try http://geohash.co/.

Check how to generate geohash on wiki: Geohash or just google it for more details.

Have you met this question in a real interview? Yes
Example
Given "wx4g0s", return lat = 39.92706299 and lng = 116.39465332.

Return double[2], first double is latitude and second double is longitude.
 * */

public class GeohashII {
    /**
     * @param geohash a base32 string
     * @return latitude and longitude a location coordinate pair
     */
    public double[] decode(String geohash) {
        // Write your code here
        String _base32 = "0123456789bcdefghjkmnpqrstuvwxyz";
        int[] mask = {16, 8, 4, 2, 1};
        double[] lon = {-180, 180};
        double[] lat = {-90, 90};
        boolean is_even = true;

        for (int i = 0; i < geohash.length(); ++i) {
            int val = _base32.indexOf(geohash.charAt(i));
            for (int j = 0; j < 5; ++j) {
                if (is_even) {
                    refine_interval(lon, val, mask[j]);
                } else {
                    refine_interval(lat, val, mask[j]);
                }
                is_even = ! is_even;
            }
        }
        double[] location = {(lat[0] + lat[1]) / 2.0, (lon[0] + lon[1]) / 2.0};
        return location;
    }

    public void refine_interval(double[] interval, int val, int mask) {
        if ((val & mask) > 0) {
            interval[0] = (interval[0] + interval[1]) / 2.0;
        } else {
            interval[1] = (interval[0] + interval[1]) / 2.0;
        }
    }
}
