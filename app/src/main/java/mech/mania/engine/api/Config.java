package mech.mania.engine.api;

import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class Config {
    // =========== BOARD CONSTANTS ===============
    public final int BOARD_HEIGHT;
    public final int BOARD_WIDTH;
    public final int GRASS_ROWS;
    public final int GREENGROCER_LENGTH;

    public final int F_BAND_INIT_POSITION;
    public final int F_BAND_INIT_DELAY;
    public final int F_BAND_MOVE_DELAY;
    public final int F_BAND_INNER_HEIGHT;
    public final int F_BAND_MID_HEIGHT;
    public final int F_BAND_OUTER_HEIGHT;

    // =========== GAME CONSTANTS ===============
    public final int STARTING_MONEY;
    public final int MAX_MOVEMENT;
    public final int PLANT_RADIUS;
    public final int HARVEST_RADIUS;
    public final int CARRYING_CAPACITY;
    public final int PROTECTION_RADIUS;

    // =========== UPGRADE CONSTANTS ============
    public final double GREEN_GROCER_LOYALTY_CARD_DISCOUNT;
    public final double RABBITS_FOOT_DOUBLE_DROP_CHANCE;
    public final int LONGER_LEGS_MAX_MOVEMENT;
    public final int SEED_A_PULT_PLANT_RADIUS;
    public final int LONGER_SCYTHE_HARVEST_RADIUS;
    public final int BACKPACK_CARRYING_CAPACITY;
    public final int SPYGLASS_PROTECTION_RADIUS;

    // ========== OTHER CONSTANTS ===============
    public final int PLAYER_TIMEOUT;

    public final Map<String, CropInformation> almanac;

    // CONSTRUCTORS
    /**
     * Constructor used for debug when you want to set your own constants.
     * @param resourceName prefix of .properties file in the resources folder
     */
    public Config(String resourceName) throws MissingResourceException {
        ResourceBundle rb = ResourceBundle.getBundle(resourceName);

        // board props
        // board props
        BOARD_HEIGHT =           Integer.parseInt(rb.getString("board.height"));
        BOARD_WIDTH =            Integer.parseInt(rb.getString("board.width"));
        GRASS_ROWS =             Integer.parseInt(rb.getString("board.grass.rows"));
        GREENGROCER_LENGTH =     Integer.parseInt(rb.getString("board.greengrocer.length"));
        F_BAND_INNER_HEIGHT =    Integer.parseInt(rb.getString("fertilityband.inner.height"));
        F_BAND_MID_HEIGHT =      Integer.parseInt(rb.getString("fertilityband.mid.height"));
        F_BAND_OUTER_HEIGHT =    Integer.parseInt(rb.getString("fertilityband.outer.height"));
        F_BAND_MOVE_DELAY =      Integer.parseInt(rb.getString("fertilityband.speed"));
        F_BAND_INIT_DELAY =      Integer.parseInt(rb.getString("fertilityband.delay"));
        F_BAND_INIT_POSITION =   Integer.parseInt(rb.getString("fertilityband.start"));

        // player props
        CARRYING_CAPACITY =      Integer.parseInt(rb.getString("player.carrycapacity"));
        MAX_MOVEMENT =           Integer.parseInt(rb.getString("player.maxmovement"));
        PLANT_RADIUS =           Integer.parseInt(rb.getString("player.plantradius"));
        HARVEST_RADIUS =         Integer.parseInt(rb.getString("player.harvestradius"));
        PROTECTION_RADIUS =      Integer.parseInt(rb.getString("player.protectionradius"));
        STARTING_MONEY =         Integer.parseInt(rb.getString("player.startingmoney"));

        PLAYER_TIMEOUT =         Integer.parseInt(rb.getString("networking.timeout.player"));

        GREEN_GROCER_LOYALTY_CARD_DISCOUNT  = Double.parseDouble(rb.getString("upgrades.green_grocer_loyalty_card_discount"));
        RABBITS_FOOT_DOUBLE_DROP_CHANCE     = Double.parseDouble(rb.getString("upgrades.rabbits_foot_double_drop_chance"));
        LONGER_LEGS_MAX_MOVEMENT            = Integer.parseInt(rb.getString("upgrades.longer_legs_max_movement"));
        SEED_A_PULT_PLANT_RADIUS            = Integer.parseInt(rb.getString("upgrades.seed_a_pult_plant_radius"));
        LONGER_SCYTHE_HARVEST_RADIUS        = Integer.parseInt(rb.getString("upgrades.longer_scythe_harvest_radius"));
        BACKPACK_CARRYING_CAPACITY          = Integer.parseInt(rb.getString("upgrades.backpack_carrying_capacity"));
        SPYGLASS_PROTECTION_RADIUS          = Integer.parseInt(rb.getString("upgrades.spyglass_protection_radius"));
        // TODO: set up almanac
         almanac = new HashMap<>();

        String[] cropTypes = {"none", "potato", "corn", "grapes", "joganfruit", "peanuts", "quadrotriticale",
                "duchamfruit", "goldencorn"};
        for (String s : cropTypes) {
            almanac.put(s, new CropInformation(rb, s));
        }
    }
}
