export enum TypeA {
  fusil_dassaut = 'fusil_dassaut',
  mitraillette = 'mitraillette',
  fusil_de_precision = 'fusil_de_precision',
  pistolet = 'pistolet',
  pierrier = 'pierrier',
  grenade = 'grenade',
  roquette = 'roquette',
  couteau = 'couteau',
  mine = 'mine',
}

export const TypeAValues: { [key in TypeA]: { prix: number; degat: number } } =
  {
    [TypeA.fusil_dassaut]: { prix: 10, degat: 10 },
    [TypeA.mitraillette]: { prix: 15, degat: 15 },
    [TypeA.fusil_de_precision]: { prix: 5, degat: 5 },
    [TypeA.pistolet]: { prix: 5, degat: 5 },
    [TypeA.pierrier]: { prix: 5, degat: 5 },
    [TypeA.grenade]: { prix: 10, degat: 10 },
    [TypeA.roquette]: { prix: 20, degat: 20 },
    [TypeA.couteau]: { prix: 5, degat: 5 },
    [TypeA.mine]: { prix: 10, degat: 10 },
  };
