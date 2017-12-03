package Models;

import java.util.HashMap;

public class Level {
    private HashMap<Character, IGameObject> objsChar = new HashMap<>();
    private GameMap map;

    public Level(HashMap<Character, IGameObject> objsChar, String[] rows) {
        this.objsChar = objsChar;
        LoadLevel(rows);
    }

    public HashMap<Character, IGameObject> getObjsChar() {
        return objsChar;
    }

    public GameMap getMap() {
        return map;
    }

    public void LoadLevel(String[] rows) {
        map = new GameMap(rows[0].length(), rows.length);

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[i].length(); j++) {
                IGameObject newObj = objsChar.get(rows[i].charAt(j));
                newObj.setPosition(new Point(i, j));
                map.addGameObject(newObj);
            }
        }
    }
}
