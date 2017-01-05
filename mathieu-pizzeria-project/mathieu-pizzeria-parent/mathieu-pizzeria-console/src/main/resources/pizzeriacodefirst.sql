CREATE TABLE `pizza` (
  `id` int(11) NOT NULL,

  `categoriePizza` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL
);


INSERT INTO `pizza` (`id`, `categoriePizza`, `code`, `nom`, `prix`, `url`) VALUES
(1,  'VIANDE', 'ORI', 'Oriental', 15.5, 'http://us.123rf.com/450wm/foodandmore/foodandmore1509/foodandmore150900088/44952168-au-four-en-forme-de-c-ur-pizza-maison-garni-de-mozzarella-et-de-tranches-de-tomate-sur-du-papier-sul.jpg?ver=6'),
(2, 'VIANDE', 'PEP', 'Pepperoni', 18.5, 'http://previews.123rf.com/images/dolgachov/dolgachov1603/dolgachov160305223/53928639-nourriture-cuisine-italienne-et-de-manger-concept-gros-plan-des-mains-tenant-et-le-partage-de-la-piz-Banque-d''images.jpg'),
(3, 'SANS_VIANDE', 'MAR', 'Margherita', 12.5, 'http://us.123rf.com/450wm/Timmary/Timmary1506/Timmary150600010/41635397-d-licieuse-pizza-savoureuse-sur-l-ancien-conseil.jpg?ver=6'),
(4,'POISSON', 'SAU', 'Saumoneta', 15.5, 'http://www.gopizz.fr/images/pizza/pizza-thon.jpg');
