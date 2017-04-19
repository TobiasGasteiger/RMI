import java.rmi.RemoteException;

/**
 * Created by Tobias on 19.04.2017.
 */
public class TaskImpl implements Task{
    @Override
    public Object quadratGeneric(Object number) throws RemoteException {
        //Only claculate when the object is a number
            return number.toString()+number.toString() + " Ich habe etwas mit dem Objekt gemacht (verdoppelt)...";

    }
}
