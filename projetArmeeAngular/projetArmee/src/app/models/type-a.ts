enum enumArme {
  fusil_dassaut = 'fusil_dassaut',
  mitraillette = 'mitraillette',
  fusil_de_precision = 'fusil_de_precision',
  pistolet = 'pistolet',
  pierrier = 'pierrier',
  grenade = 'grenade',
  roquette = 'roquette',
  couteau = 'couteau',
}

export interface TypeA {
  name: enumArme;
  prix: number;
  degat: number;
}

export const TypeAValues: TypeA[] = [
  { name: enumArme.fusil_dassaut, prix: 10, degat: 10 },
  { name: enumArme.mitraillette, prix: 15, degat: 15 },
  { name: enumArme.fusil_de_precision, prix: 5, degat: 5 },
  { name: enumArme.pistolet, prix: 5, degat: 5 },
  { name: enumArme.pierrier, prix: 5, degat: 5 },
  { name: enumArme.grenade, prix: 10, degat: 10 },
  { name: enumArme.roquette, prix: 20, degat: 20 },
  { name: enumArme.couteau, prix: 5, degat: 5 },
];
