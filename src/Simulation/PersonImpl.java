package Simulation;

import com.jme3.math.Vector3f;

import com.jme3.scene.Spatial;

class PersonImpl implements Entity, Person {
    private GraphicsComponent gfx;
    private PhysicsComponent  phyc;
    private boolean infected;
    private Mask mask;
    private Vector3f oldPos, pos;
    
    
    public PersonImpl(){       
        gfx = new GraphicsComponent(this);
        phyc = new PhysicsComponent(this);
        
    }

    public Vector3f algoritmoMovimento() {
        throw new UnsupportedOperationException();
    }
    @Override
    public void update() {
        Vector3f newPos = algoritmoMovimento();
        oldPos = pos;
        pos = newPos;
        gfx.move(newPos);
    }
    @Override
    public Spatial getSpatial() {
        return gfx.getSpatial();
    }
    @Override
    public void collision(Entity e) {
        switch (e.getIdentificator()) {
        case PERSON:
            // algoritmo infezione
            break;
        case WALL:
            // move back
            break;
        case UNKNOWN:
            throw new UnsupportedOperationException();
        default:
            throw new UnsupportedOperationException();
        }
    }
    @Override
    public Identificator getIdentificator() {
        return Identificator.PERSON;
    }
    @Override
    public Mask getMask(){
        return mask;
    }
    @Override
    public void wearMask(Mask m){
        this.mask = m;
    }
    @Override
    public void maskDown(){
        this.mask.maskDown();
    }
    @Override
    public boolean isInfected(){
        return infected;
    }
    @Override
    public void infect()
    {
        infected = true;
    }
}

