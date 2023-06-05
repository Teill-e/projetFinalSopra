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
  { name: enumArme.fusil_dassaut, prix: 10, degat: 10 },
  { name: enumArme.fusil_dassaut, prix: 10, degat: 10 },
  { name: enumArme.pistolet, prix: 5, degat: 5 },
  { name: enumArme.fusil_dassaut, prix: 10, degat: 10 },
  { name: enumArme.fusil_dassaut, prix: 10, degat: 10 },
  { name: enumArme.fusil_dassaut, prix: 10, degat: 10 },
  { name: enumArme.fusil_dassaut, prix: 10, degat: 10 },
];

/*[TypeA.fusil_dassaut]: { prix: 10, degat: 10 },
    [TypeA.mitraillette]: { prix: 15, degat: 15 },
    [TypeA.fusil_de_precision]: { prix: 5, degat: 5 },
    [TypeA.pistolet]: { prix: 5, degat: 5 },
    [TypeA.pierrier]: { prix: 5, degat: 5 },
    [TypeA.grenade]: { prix: 10, degat: 10 },
    [TypeA.roquette]: { prix: 20, degat: 20 },
    [TypeA.couteau]: { prix: 5, degat: 5 },
    [TypeA.mine]: { prix: 10, degat: 10 },*/
