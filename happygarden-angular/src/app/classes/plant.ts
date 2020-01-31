import { GrowthRate } from '../enums/growth-rate.enum';
import { Season } from '../enums/season.enum';

export class Plant {
  scientificName: string;
  commonName: string;
  familyCommonName: string;
  toxicity: string;
  matureHeight: number;
  lifeSpan: string;
  image: string;
  bloomPeriod: string;
  growthRate: GrowthRate;
  seasons: Season[];
}
