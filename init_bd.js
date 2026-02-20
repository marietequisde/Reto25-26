db = db.getSiblingDB('plantas');

db.origen.drop();
db.planta.drop();

let origenes = db.origen.insertMany([
  { nombre: 'India', continente: 'Asia' },
  { nombre: 'Mediterráneo', continente: 'Europa' },
  { nombre: 'Europa', continente: 'Europa' },
  { nombre: 'México', continente: 'Centroamérica' },
  { nombre: 'Estados Unidos', continente: 'Norteamérica' },
  { nombre: 'Zonas Tropicales', continente: 'Varios' },
  { nombre: 'Sudeste Asiático', continente: 'Asia' },
  { nombre: 'Arabia', continente: 'África' },
  { nombre: 'Japón', continente: 'Asia' },
]);


db.planta.insertMany([
  {
    nombre: 'Albahaca', familia: 'Lamiáceas', valorCulinario: 'Alto', altura: 40,
    descripcion: 'Hierba aromática esencial para el pesto.',
    origen: origenes.insertedIds[0]
  },
  {
    nombre: 'Lavanda', familia: 'Lamiáceas', valorCulinario: 'Bajo', altura: 60,
    descripcion: 'Famosa por su fragancia y propiedades relajantes.',
    origen: origenes.insertedIds[1]
  },
  {
    nombre: 'Menta', familia: 'Lamiáceas', valorCulinario: 'Medio', altura: 30,
    descripcion: 'Planta refrescante de crecimiento muy rápido.',
    origen: origenes.insertedIds[2]
  },
  {
    nombre: 'Cactus de Asiento', familia: 'Cactáceas', valorCulinario: 'Nulo', altura: 50,
    descripcion: 'Planta suculenta globosa con espinas amarillas.',
    origen: origenes.insertedIds[3]
  },
  {
    nombre: 'Romero', familia: 'Lamiáceas', valorCulinario: 'Alto', altura: 150,
    descripcion: 'Arbusto leñoso muy utilizado en guisos y carnes.',
    origen: origenes.insertedIds[1]
  },
  {
    nombre: 'Girasol', familia: 'Asteráceas', valorCulinario: 'Medio', altura: 200,
    descripcion: 'Planta que sigue la ruta del sol durante el día.',
    origen: origenes.insertedIds[4]
  },
  {
    nombre: 'Helecho Espada', familia: 'Polypodiaceae', valorCulinario: 'Nulo', altura: 90,
    descripcion: 'Planta ornamental clásica para interiores sombríos.',
    origen: origenes.insertedIds[5]
  },
  {
    nombre: 'Orquídea Phalaenopsis', familia: 'Orchidaceae', valorCulinario: 'Nulo', altura: 45,
    descripcion: 'Flor elegante conocida como orquídea mariposa.',
    origen: origenes.insertedIds[6]
  },
  {
    nombre: 'Aloe Vera', familia: 'Asphodelaceae', valorCulinario: 'Bajo', altura: 60,
    descripcion: 'Conocida por las propiedades medicinales de su gel.',
    origen: origenes.insertedIds[7]
  },
  {
    nombre: 'Bambú de la Suerte', familia: 'Asparagaceae', valorCulinario: 'Nulo', altura: 100,
    descripcion: 'Común en decoración, técnicamente es una Dracaena.',
    origen: origenes.insertedIds[7]
  }
]);

db.createView(
  "vista_plantas",
  "planta",
  [
    {
      $lookup: {
        from: 'origen',
        localField: 'origen',
        foreignField: '_id',
        as: 'datos_origen'
      }
    },
    { $unwind: '$datos_origen' },
    {
      $project: {
        nombre: 1,
        familia: 1,
        valorCulinario: 1,
        altura: 1,
        descripcion: 1,
        origen_nombre: '$datos_origen.nombre',
        origen_continente: '$datos_origen.continente'
      }
    }
  ]
)