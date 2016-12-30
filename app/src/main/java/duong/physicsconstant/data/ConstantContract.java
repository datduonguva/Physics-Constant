package duong.physicsconstant.data;

import android.provider.BaseColumns;

/**
 * Created by duong on 12/21/2016.
 */

public class ConstantContract implements BaseColumns {
    public static final class ClassicalMechanics{
        public static final String TABLE_NAME = "classicalmechanics";
        public static final String COLUMN_ID = BaseColumns._ID;

        public static final String COLUMN_NAME = "NAME";
        public static final String COLUMN_VALUE = "VALUE";

    }

    public static final class ThermalDynamics{
        public static final String TABLE_NAME = "ThermalDynamics";
        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "NAME";
        public static final String COLUMN_VALUE = "VALUE";
    }
    public static final class Prefix{
        public static final String TABLE_NAME = "prefix";
        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "NAME";
        public static final String COLUMN_VALUE = "VALUE";
    }
    public static final class ElectroMagnetism{
        public static final String TABLE_NAME = "electromagnetism";
        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "NAME";
        public static final String COLUMN_VALUE = "VALUE";
    }
    public static final class Optics{
        public static final String TABLE_NAME = "optics";
        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "NAME";
        public static final String COLUMN_VALUE = "VALUE";
    }
    public static final class NuclearPhysics{
        public static final String TABLE_NAME = "nuclearphysics";
        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "NAME";
        public static final String COLUMN_VALUE = "VALUE";
    }

    public static final class LengthConversion{
        public static final String TABLE_NAME = "lengthconversion";
        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "NAME";
        public static final String COLUMN_VALUE = "VALUE";
    }
}
