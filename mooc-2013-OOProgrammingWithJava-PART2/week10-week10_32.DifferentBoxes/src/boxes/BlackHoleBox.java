/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

/**
 *
 * @author davido
 */
public class BlackHoleBox extends Box {

    @Override
    public void add(Thing thing) {
        return;
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return false;
    }
    
}
