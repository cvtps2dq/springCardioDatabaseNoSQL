package ru.cv2.springmongodb.factories;

import com.github.javafaker.Faker;
import ru.cv2.springmongodb.documents.Block;
import ru.cv2.springmongodb.documents.Patient;
import ru.cv2.springmongodb.repositories.BlockRepository;
import ru.cv2.springmongodb.repositories.PatientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PatientFactory {

    private final Faker faker = new Faker();
    private List<Block> blockList = new ArrayList<>();
    private final PatientRepository patientRepository;
    private final BlockRepository blockRepository;
    private final Random rand = new Random();
    private final String[] conditionList = new String[]{"Stable", "Critical", "Dead"};
    private final String[] diagnosisList = new String[]{
            "Accelerated idioventricular rhythm","Acute decompensated heart failure","Arteriosclerotic heart disease",
            "Athletic heart syndrome","Atrial flutter","Atrioventricular fistula",
            "Autoimmune heart disease","Bernheim syndrome","Brown atrophy of the heart","Ebb Cade",
            "Cardiac allograft vasculopathy","Cardiac amyloidosis","Cardiac asthma",
            "Cardiac tamponade","Cardiogenic shock","Cardiorenal syndrome","Cardiotoxicity",
            "Carditis","Coronary artery aneurysm","Coronary artery anomaly","Coronary artery disease",
            "Spontaneous coronary artery dissection","Coronary artery ectasia","Coronary occlusion","Coronary steal",
            "Coronary thrombosis","Coronary vasospasm","Cœur en sabot","Coxsackievirus-induced cardiomyopathy",
            "Duroziez's disease","Eisenmenger syndrome","Embryocardia","Endocardial fibroelastosis",
            "Eosinophilic myocarditis","Heart failure","Heart failure with preserved ejection fraction",
            "High-output heart failure","Hyperdynamic precordium","Idiopathic giant-cell myocarditis",
            "Interventricular dyssynchrony","Intraventricular dyssynchrony","Isolated atrial amyloidosis",
            "Keshan disease","Loeffler endocarditis","Myocardial bridge","Myocardial disarray",
            "Myocardial injury after non-cardiac surgery","Myocardial rupture","Myocardial scarring",
            "Myocardial stunning","Myocarditis","Nonbacterial thrombotic endocarditis","Ostial disease",
            "Papillary fibroelastoma","Pathophysiology of heart failure","Postpericardiotomy syndrome",
            "Progressive cardiac conduction defect","Pulmonary vein stenosis","Right axis deviation",
            "Right ventricular hypertrophy","Roemheld syndrome","Shone's syndrome","Strain pattern",
            "Structural heart disease","Subacute bacterial endocarditis",
            "Takotsubo cardiomyopathy","Traumatic cardiac arrest","Ventricular aneurysm",
            "Vibroacoustic disease","Viral cardiomyopathy"
    };

    public PatientFactory(PatientRepository patientRepository, BlockRepository blockRepository) {
        this.patientRepository = patientRepository;
        this.blockRepository = blockRepository;
    }


    public void generate(int count) {
        blockList = blockRepository.findAll();
        for (int i = 0; i < count; i++) {
            Patient patient = new Patient();
            patient.setBlockId(blockList.get(rand.nextInt(blockList.size())).getId());
            patient.setName(faker.name().firstName());
            patient.setSurname(faker.name().lastName());
            patient.setCondition(conditionList[rand.nextInt(conditionList.length)]);
            patient.setAge(rand.nextInt(0, 99));
            patient.setDiagnosis(diagnosisList[rand.nextInt(diagnosisList.length)]);
            patientRepository.save(patient);
        }
    }

}
