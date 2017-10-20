package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.effect.ParticleEmitter;
import com.jme3.effect.ParticleMesh;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyEventSubscriber;
import de.lessvoid.nifty.controls.ButtonClickedEvent;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import tools.Herramientas;

/**
 * test
 *
 * @author normenhansen
 */
public class Main extends SimpleApplication implements ScreenController {

    private Nifty nifty;
    Geometry g1;
    Geometry g2;
    Spatial Te;

    public static void main(String[] args) {
        Main app = new Main();
        app.setShowSettings(false);
        // app.setS;
        app.start();
    }

    @Override
    public void simpleInitApp() {
        setUpNiftyGUI();
        // Se quita el control de la camara del mouse
        flyCam.setEnabled(false);
        // Se muestra el mouse para poder seleccionar los objetos.
        inputManager.setCursorVisible(true);

        g1 = Herramientas.createNode(assetManager, "Caja1", new ColorRGBA(ColorRGBA.Red), new Vector3f(-3f, 0f, 0f));
        rootNode.attachChild(g1);

        g2 = Herramientas.createNode(assetManager, "Caja2", new ColorRGBA(ColorRGBA.Blue), new Vector3f(0f, 0f, 0f));
        rootNode.attachChild(g2);

        /**
         * Uses Texture from jme3-test-data library!
         */
        /**
         * A white ambient light source.
         */
//        Box b = new Box(1, 1, 1);
//        Geometry geom = new Geometry("Box", b);
//
//        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        mat.setColor("Color", ColorRGBA.Blue);
//        geom.setMaterial(mat);
//
//        rootNode.attachChild(geom);
        /**
         * A white, directional light source
         */
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection((new Vector3f(-0.5f, -0.5f, -0.5f)).normalizeLocal());
        sun.setColor(ColorRGBA.White);
        rootNode.addLight(sun);

    }

    private void setUpNiftyGUI() {
        NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
        nifty = niftyDisplay.getNifty();
        nifty.fromXml("Interface/gui.xml", "startScreen", this);
        guiViewPort.addProcessor(niftyDisplay);
    }

    @NiftyEventSubscriber(id = "bmostrarazul")
    public void onSwitchButtonMostrarAzul(final String id, final ButtonClickedEvent event) {
//        Geometry g = (Geometry) rootNode.getChild("Caja Azul");
//        g.setCullHint(Spatial.CullHint.Never);
        System.out.println("hola mundo ");
        //Geometry g11 = (Geometry) rootNode.getChild("Caja1");
        rootNode.getChild("Caja1").removeFromParent();
        //g11.setCullHint(Spatial.CullHint.Inherit);
        //rootNode.detachAllChildren();

    }

    @NiftyEventSubscriber(id = "bmostrarverde")
    public void onSwitchButtonMostrarverde(final String id, final ButtonClickedEvent event) {


        ParticleEmitter fireEffect = new ParticleEmitter("Emitter", ParticleMesh.Type.Triangle, 30);
        Material fireMat = new Material(assetManager, "Common/MatDefs/Misc/Particle.j3md");
        //fireMat.setTexture("Texture", assetManager.loadTexture("Effects/Explosion/flame.png"));
        fireEffect.setMaterial(fireMat);
        fireEffect.setImagesX(2);
        fireEffect.setImagesY(2); // 2x2 texture animation
        fireEffect.setEndColor(new ColorRGBA(1f, 0f, 0f, 1f));   // red
        fireEffect.setStartColor(new ColorRGBA(1f, 1f, 0f, 0.5f)); // yellow
        fireEffect.getParticleInfluencer().setInitialVelocity(new Vector3f(0, 2, 0));
        fireEffect.setStartSize(0.6f);
        fireEffect.setEndSize(0.1f);
        fireEffect.setGravity(0f, 0f, 0f);
        fireEffect.setLowLife(0.5f);
        fireEffect.setHighLife(3f);
        fireEffect.getParticleInfluencer().setVelocityVariation(0.3f);
        rootNode.attachChild(fireEffect);
    }

    @NiftyEventSubscriber(id = "bocultarverde")
    public void onSwitchButtonOcultarverde(final String id, final ButtonClickedEvent event) {

        rootNode.attachChild(assetManager.loadModel("Models/Oto.mesh.j3o"));
//        AmbientLight ambient = new AmbientLight();
//        ambient.setColor(ColorRGBA.White);
//        rootNode.addLight(ambient);
    }

    @NiftyEventSubscriber(id = "bocultarazul")
    public void onSwitchButtonOcultarazul(final String id, final ButtonClickedEvent event) {

        Te = assetManager.loadModel("scenes/escena.j3o");
        Te.setLocalTranslation(0f, -2f, 0f);
        rootNode.attachChild(Te);

    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }

    public void bind(Nifty nifty, Screen screen) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void onStartScreen() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void onEndScreen() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
