package Components;

/*
import java.awt.Rectangle;
import java.util.List;
import com.jme3.ai.navmesh.Path.Waypoint;
import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.cinematic.MotionPath;
import com.jme3.cinematic.events.MotionEvent;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
*/
import com.jme3.scene.Spatial;

public class MovementComponent { //extends MotionEvent {
    /*
        Giving this class a Rectangle as such -> this(pos, --new Rectangle(50, 50)--) means that,
        whenever we generate a new point, that point is choosen inside a 100x100 "rectangle".
        As for now we only use rectangles to find new points given a point 'pos'.
        In future implementations we'll see them in use for walls detection and stuff...
     */
    // static private final Rectangle DEFAULT_AREA = new Rectangle(50, 50);
    // private Vector3f position;
    // private final Rectangle area;
    // private PollingArea pArea;
    // private BetterCharacterControl spatialControl;
    // private boolean isPathfinding, isMovementEnabled;
    private Spatial scene;
    private PathGenerator pg;
    private PathFollower pathFollower;
    // private boolean isWaiting = true;

    public MovementComponent(
            final Spatial spatial,
            final Spatial scene
            //final Vector3f position,
            //final Rectangle area
    ) {
        //super(spatial, new MotionPath());
        // this.position = position;
        // this.area = area;
        // this.spatial = spatial;
        this.scene = scene;
        pg = new PathGenerator(scene);
        pathFollower = new PathFollower(spatial, pg);//, pg.getRandomPoint());
        // this.spatialControl = spatial.getControl(BetterCharacterControl.class);
        //this.setSpeed(300 / path.getLength());
    }

    /*
    public MovementComponent(final Spatial spatial, final Spatial scene, final Vector3f position) {
        this(spatial, scene, position, DEFAULT_AREA);
    }
    */

    public void startPathFollower(){
        // pathFollower.start();
    }

    public void update(float tpf){
        pathFollower.update();
    }

    // public Vector3f getPosition() {
    //     return position;
    // }

    // public Vector3f getNextPoint() {
    //     this.pArea = new PollingArea(area, 10);
    //     this.position = this.position.add(pArea.getRandomOffset());
    //     return this.position;
    // }

    // public void moveToNextPointInPath() {
    //     this.play();
    // }

    // @Override
    // public void onStop() {
    //     path = null;
    //     path = new MotionPath();
    //     path.addWayPoint(this.position);
    //     path.addWayPoint(new Vector3f(getNextPoint()));
    //     path.addWayPoint(new Vector3f(getNextPoint()));
    //     path.addWayPoint(new Vector3f(getNextPoint()));
    //     this.setPath(path);
    //     this.setSpeed(300 / path.getLength());
    //     this.play();
    // }

    // public MotionPath getPath() {
    //     return this.path;
    // }

    // public void moveDirection(final Vector3f direction) {
    //     Vector3f v = direction.subtract(spatial.getLocalTranslation());
    //     spatialControl.setViewDirection(v.negate());
    //     spatialControl.setWalkDirection(v.normalize().mult(10));
    // }

    // public void stopWalking() {
    //     spatialControl.setWalkDirection(Vector3f.ZERO);
    // }


    // public void followPath(final List<Waypoint> path){
    //     for(var w : path){
    //         while(this.spatial.getLocalTranslation().distance(w.getPosition()) >= 1){
    //             var v = w.getPosition().subtract(this.spatial.getLocalTranslation());
    //             this.moveDirection(v.normalize().mult(10));
    //         }
    //         stopWalking();
    //     }
    // }
}