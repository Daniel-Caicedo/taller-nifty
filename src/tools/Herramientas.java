/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import com.jme3.asset.AssetManager;
import com.jme3.input.InputManager;
import com.jme3.input.controls.InputListener;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 *
 * @author alejo
 */
public class Herramientas
{
    /**
     * Metodo de registro de acciones.
     * @param im Referncia al Manejador de eventos
     * @param button Identificador del boton que se activa.
     * @param command Nombre con el que se identifica en la aplicacion
     * @param il Objeto que escucha los eventos.
     */
    public static void activateAction(InputManager im, int button, String command, InputListener il) {
        im.addMapping(command, new MouseButtonTrigger(button));
        im.addListener(il, command);
    }

    /**
     * Metodo de creación de objetos(cubos).
     * @param am Referencia al Manejador de Objeto Gráficos.
     * @param name Nombre del objeto creado.
     * @param color Color del objeto creado.
     * @param pos Posición Inicial.
     * @return Objeto Grafico que se agrega a la escena.
     */
    public static Geometry createNode(AssetManager am, String name, ColorRGBA color, Vector3f pos) {
        Box b = new Box(Vector3f.ZERO, 0.5f, 0.5f, 0.5f);
        Geometry geom = new Geometry(name, b);

        Material mat = new Material(am, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", color);
        geom.setMaterial(mat);
        geom.setLocalTranslation(pos);

        return geom;
    }

}
