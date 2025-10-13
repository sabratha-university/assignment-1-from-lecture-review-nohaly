public class SimpleLocation {
    private double latitude;   // خط العرض
    private double longitude;  // خط الطول

    // Constructor
    public SimpleLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    // دالة لحساب المسافة بين موقعين باستخدام معادلة Haversine
    public static double haversineDistanceKm(SimpleLocation a, SimpleLocation b) {
        final double R = 6371.0; // نصف قطر الأرض بالكيلومتر
        double lat1 = Math.toRadians(a.getLatitude());
        double lon1 = Math.toRadians(a.getLongitude());
        double lat2 = Math.toRadians(b.getLatitude());
        double lon2 = Math.toRadians(b.getLongitude());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double sinDLat = Math.sin(dLat / 2);
        double sinDLon = Math.sin(dLon / 2);
        double aa = sinDLat * sinDLat + Math.cos(lat1) * Math.cos(lat2) * sinDLon * sinDLon;
        double c = 2 * Math.atan2(Math.sqrt(aa), Math.sqrt(1 - aa));

        return R * c;
    }

    @Override
    public String toString() {
        return String.format("(%.6f, %.6f)", latitude, longitude);
    }

    public static void main(String[] args) {
        // موقع جامعة صبراتة
        SimpleLocation myLocation = new SimpleLocation(32.79813, 12.49111);
        // موقع كلية تقنية المعلومات الجميل
        SimpleLocation college = new SimpleLocation(32.8559851, 12.0575469);

        // حساب المسافة
        double distance = haversineDistanceKm(myLocation, college);

        // عرض الإحداثيات والمسافة
        System.out.println("إحداثيات جامعة صبراتة: " + myLocation);
        System.out.println("إحداثيات كلية تقنية المعلومات الجميل: " + college);
        System.out.printf("المسافة بين الموقعين هي: %.2f كم%n", distance);
    }
}
