from sys import platform as sys_pf
if sys_pf == 'darwin':
	import matplotlib
	matplotlib.use('TkAgg')
import matplotlib.pyplot as plt

x1 = [1.0,0.9995015891261738,0.9980068533314934,0.995517282601106,0.9920353585932578,0.9875645521655237,0.9821093199149804,0.9756750997357736,0.9682683053985072,0.959896320156857,0.9505674893877829,0.9402911122726756,0.9290774325277306,0.9169376281927888,0.9038838004888236,0.8899289617551803,0.8750870224785937,0.859372777426912,0.8428018909013506,0.8253908811219762,0.8071571037619854,0.7881187346471924,0.7682947516379708,0.7477049157117092,0.7263697512646394,0.7043105256526722,0.6815492279916338,0.6581085472380377,0.6340118495722387,0.6092831551065166,0.5839471139413063,0.5580289815934402,0.5315545938209014,0.5045503408691775,0.47704314116488955,0.44906041448292017,0.42063005461378417,0.39178040155849314,0.3625402132786245,0.33293863702976106,0.30300518030687273,0.2727696814306032,0.24226227980378318,0.21151338586781906,0.18055365078890231,0.14941393590426094,0.11812528195890805,0.08671887816355073,0.05522603110450817,0.0236781335366241,-0.00789336690971331,-0.0394569990762527,-0.070981299648016,-0.10243484451661329,-0.13378628010447904,-0.1650043546187993,-0.196057949203978,-0.22691610896159004,-0.2575480738068967,-0.28792330913116637,-0.3180115362392381,-0.34778276253198237,-0.37720731140357594,-0.40625585182378904,-0.434899427575793,-0.4631094861203477,-0.4908579070575935,-0.5181170301580775,-0.5448596829350705,-0.5710592077306947,-0.5966894882888559,-0.6217249757884951,-0.6461407143112099,-0.6699123657178553,-0.6930162339093318,-0.7154292884473712,-0.7371291875117789,-0.7580943001712453,-0.77830372794553,-0.7977373256375193,-0.8163757214143991,-0.8342003361179174,-0.8511934017844945,-0.8673379793567146,-0.8826179755685469,-0.8970181589874635,-0.9105241751974622,-0.9231225611078606,-0.9348007583735982,-0.9455471259136671,-0.9553509515151948,-0.9642024625116117,-0.972092835524257,-0.9790142052577144,-0.9849596723401105,-0.9899233102005571,-0.9939001709768878,-0.9968862904477932,-0.9988786919844436,-0.9998753895176573,-0.9998753895176573,-0.9988786919844436,-0.9968862904477932,-0.9939001709768879,-0.9899233102005571,-0.9849596723401105,-0.9790142052577145,-0.972092835524257,-0.9642024625116118,-0.9553509515151949,-0.9455471259136671,-0.9348007583735983,-0.9231225611078607,-0.9105241751974622,-0.8970181589874636,-0.8826179755685468,-0.8673379793567146,-0.8511934017844947,-0.8342003361179176,-0.8163757214143992,-0.7977373256375195,-0.7783037279455299,-0.7580943001712456,-0.737129187511779,-0.7154292884473714,-0.693016233909332,-0.6699123657178551,-0.6461407143112101,-0.6217249757884953,-0.5966894882888557,-0.571059207730695,-0.5448596829350704,-0.5181170301580778,-0.49085790705759375,-0.4631094861203475,-0.4348994275757932,-0.40625585182378887,-0.37720731140357633,-0.3477827625319824,-0.3180115362392379,-0.28792330913116665,-0.2575480738068965,-0.22691610896159048,-0.19605794920397804,-0.1650043546187989,-0.13378628010447927,-0.1024348445166131,-0.07098129964801624,-0.03945699907625272,-0.007893366909713777,0.023678133536623857,0.05522603110450836,0.08671887816355048,0.11812528195890803,0.14941393590426047,0.1805536507889021,0.21151338586781926,0.24226227980378293,0.27276968143060315,0.3030051803068723,0.332938637029761,0.36254021327862473,0.3917804015584929,0.42063005461378433,0.4490604144829198,0.47704314116488955,0.5045503408691777,0.5315545938209012,0.5580289815934403,0.5839471139413059,0.6092831551065166,0.6340118495722389,0.6581085472380375,0.681549227991634,0.7043105256526719,0.7263697512646393,0.7477049157117087,0.7682947516379706,0.7881187346471925,0.8071571037619851,0.8253908811219762,0.8428018909013504,0.8593727774269119,0.8750870224785938,0.8899289617551801,0.9038838004888236,0.9169376281927886,0.9290774325277305,0.9402911122726756,0.9505674893877828,0.959896320156857,0.9682683053985071,0.9756750997357736,0.9821093199149804,0.9875645521655236,0.9920353585932579,0.9955172826011058,0.9980068533314933,0.9995015891261738,1.0];
y1 = [0.0,0.03156854976481053,0.06310563131267365,0.09457980779484494,0.12595970506771756,0.15721404296725078,0.18831166648971787,0.21922157684769134,0.24991296237030836,0.28035522921701445,0.3105180318741688,0.3403713034041128,0.3698852854165468,0.399030557732341,0.4277780677102096,0.45609915920701594,0.48396560114283876,0.5113496156423267,0.5382239057242886,0.5645616825119181,0.5903366919365284,0.6155232409081792,0.6400962229271071,0.6640311431104312,0.6873041426091843,0.7098920223913329,0.7317722663670768,0.752923063833377,0.773323331215339,0.7929527330827786,0.8117917024210207,0.8298214601357258,0.8470240337722988,0.8633822754312233,0.8788798788614604,0.8935013957148741,0.9072322509454814,0.9200587573381745,0.9319681291524349,0.942948494867437,0.9529889090158392,0.9620793630944628,0.9702107955409863,0.9773751007667072,0.9835651372363698,0.9887747345870026,0.9929986997786696,0.9962328222710067,0.9984738782203788,0.9997196336934779,0.9999688468941563,0.9992212694012756,0.9974776464163387,0.9947397160206569,0.9910102074427921,0.9862928383380027,0.9805923110824041,0.9739143080855378,0.9662654861260218,0.9576534697159296,0.9480868435005095,0.9375751437008251,0.9261288486078413,0.9137593681374367,0.9004790324567516,0.8863010796932087,0.8712396427384597,0.8553097351604118,0.8385272362373773,0.8209088751292626,0.802472214201578,0.7832356315188905,0.7632183025251684,0.742440180929283,0.7209219788147163,0.6986851459933066,0.6757518486236088,0.6521449471151868,0.6278879733408583,0.6030051071796145,0.5775211524135886,0.5514615120031076,0.5248521627644684,0.497719629475683,0.47009095843600296,0.44199369050557913,0.4134558336521342,0.384505835032011,0.3551725526334286,0.3254852265102116,0.29547344963467004,0.2651671383986787,0.23459650279236888,0.20379201629015234,0.17278438547409944,0.14160451942495159,0.11028349891127508,0.0788525454074766,0.047342989971558204,0.01578624201363682,-0.015786242013637018,-0.04734298997155796,-0.07885254540747635,-0.11028349891127483,-0.14160451942495178,-0.17278438547409963,-0.20379201629015212,-0.23459650279236863,-0.2651671383986785,-0.2954734496346698,-0.32548522651021183,-0.3551725526334284,-0.38450583503201075,-0.41345583365213395,-0.4419936905055789,-0.4700909584360031,-0.49771962947568316,-0.5248521627644683,-0.5514615120031073,-0.5775211524135885,-0.6030051071796143,-0.6278879733408584,-0.6521449471151866,-0.6757518486236087,-0.6986851459933063,-0.7209219788147162,-0.7424401809292832,-0.7632183025251682,-0.7832356315188904,-0.8024722142015781,-0.8209088751292625,-0.8385272362373775,-0.8553097351604116,-0.8712396427384596,-0.8863010796932088,-0.9004790324567515,-0.9137593681374367,-0.9261288486078411,-0.9375751437008251,-0.9480868435005096,-0.9576534697159295,-0.9662654861260219,-0.9739143080855377,-0.9805923110824041,-0.9862928383380027,-0.9910102074427921,-0.994739716020657,-0.9974776464163387,-0.9992212694012756,-0.9999688468941563,-0.9997196336934779,-0.9984738782203788,-0.9962328222710067,-0.9929986997786696,-0.9887747345870026,-0.98356513723637,-0.9773751007667072,-0.9702107955409863,-0.9620793630944628,-0.9529889090158394,-0.942948494867437,-0.9319681291524348,-0.9200587573381745,-0.9072322509454813,-0.8935013957148743,-0.8788798788614604,-0.8633822754312233,-0.847024033772299,-0.8298214601357258,-0.811791702421021,-0.7929527330827786,-0.7733233312153388,-0.7529230638333771,-0.7317722663670767,-0.7098920223913332,-0.6873041426091843,-0.6640311431104317,-0.6400962229271073,-0.615523240908179,-0.5903366919365287,-0.5645616825119181,-0.538223905724289,-0.5113496156423268,-0.48396560114283854,-0.45609915920701627,-0.42777806771020954,-0.3990305577323414,-0.36988528541654697,-0.34037130340411265,-0.3105180318741691,-0.28035522921701433,-0.2499129623703088,-0.21922157684769145,-0.18831166648971762,-0.15721404296725106,-0.12595970506771748,-0.09457980779484539,-0.06310563131267372,-0.031568549764810244,-2.4492935982947064E-16];
plt.plot(x1, y1, color='b', linestyle='-', linewidth=2)
plt.xlabel('X')
plt.ylabel('Y')
plt.grid(True, which='both', axis='both')
plt.savefig('./tests/org/gsl4j/tests/test/fig2.png')
