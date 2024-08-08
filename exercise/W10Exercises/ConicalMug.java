public class ConicalMug extends Mug {
    private int base;

    public ConicalMug(String name, int height, int width, int base) {
        super(name, height, width);
        this.base = base;
    }
    
    public double getConicalVolume() {
        if ( base == getWidth() ) { return super.getVolume(); }
        double radius_top = getWidth()/2.0;
        double radius_base = base/2.0;
        double area_top = Math.PI * radius_top * radius_top; 
        double area_base = Math.PI * radius_base * radius_base;
        double height_extension = getHeight() * radius_base/(radius_top - radius_base);
        double height_total = height_extension + getHeight();
        double volume_cone = area_top * height_total/3;
        double volume_extension = area_base * height_extension/3;
        return (volume_cone - volume_extension)/ 1000000;
    }

    public int getConicalMarshmallowLimit() {
        double volume = getConicalVolume();
        return (int)(volume/Mug.LITRES_PER_MALLOW);
    }

    public void printConical() {
        System.out.printf("%s mug (%dmm x %dmm -> %dmm), holding %.3fl and up to %d marshmallows.%n", 
            getName(), getHeight(), getWidth(), base, getConicalVolume(), getConicalMarshmallowLimit());
    }
}
