package br.com.badcompany.android.backend;

import static spark.Spark.get;
import static spark.Spark.post;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.badcompany.android.backend.model.Moto;

public class App {
	public static Gson gson;
	public static Type col;
	
	public static void main(String[] args) throws IOException {
	
		col = new TypeToken<List<Moto>>() {}.getType();
		gson = new Gson();
		
		Moto m1 = new Moto(1, "V-Rod", "Harley-Davidson", "http://motordream.uol.com.br/upload/noticia/13895757499537.jpg", false);
		Moto m2 = new Moto(2, "IRON 883", "Harley-Davidson", "http://www.motoriorentals.com.br/es/media/k2/items/cache/6f43b5263fbba79c5962514b85d34738_L.jpg", false);
		Moto m3 = new Moto(3, "1200 CUSTOM CB", "Harley-Davidson", "http://www.moto.com.br/img/2014/03/12/img75160-1394633809-v580x435.jpg", false);
		Moto m4 = new Moto(4, "FORTY-EIGHT", "Harley-Davidson", "http://www.memoriamotor.r7.com/wp-content/uploads/2015/06/Forty-Eight.jpg", false);
		Moto m5 = new Moto(5, "ROADSTER", "Harley-Davidson", "http://motorcycle.com.vsassets.com/blog/wp-content/uploads/2016/05/050316-Harley-Davidson-Roadster-1-9.jpg", false);
		Moto m6 = new Moto(6, "STREET BOB", "Harley-Davidson", "https://i.ytimg.com/vi/bYHiaKMpSaE/maxresdefault.jpg", false);
		Moto m7 = new Moto(7, "V Star 1300", "Yamaha", "https://cloud.yamahamotorsports.com/library/img.jpg?id=26284&w=840", false);
		Moto m8 = new Moto(8, "Bolt R-Spec", "Yamaha", "http://s1.cdn.autoevolution.com/images/moto_gallery/YAMAHABoltR-4399_10.jpg", false);
		Moto m9 = new Moto(9, "V Star 950 Tourer", "Yamaha", "http://moto.zombdrive.com/images/yamaha-v-star-950-tourer-1.jpg", false);
		List<Moto> motos = new ArrayList<>();
		motos.add(m1);
		motos.add(m2);
		motos.add(m3);
		motos.add(m4);
		motos.add(m5);
		motos.add(m6);
		motos.add(m7);
		motos.add(m8);
		motos.add(m9);
		
		
		get("/motos/list", (req, res) -> {
			res.type("application/json");
			res.status(200);
			return gson.toJson(motos);
		});
		
		post("/motos/save", (req, res) -> {
			Moto m = gson.fromJson(req.body(),Moto.class);
			res.type("application/json");
			res.status(200);
			motos.add(m);
			return gson.toJson(m); 
		});
		
		get("/motos/favoritar/:id", (req, res) -> {
			int id = Integer.parseInt(req.params(":id"));
			res.type("application/json");
			for(Moto m : motos) {
				if(m.getId() == id) {
					res.status(200);				
					m.setEhFavorito(true);
					return gson.toJson(m);
				}
			}
			res.status(404);
			return "";
		});
		
	}
}
