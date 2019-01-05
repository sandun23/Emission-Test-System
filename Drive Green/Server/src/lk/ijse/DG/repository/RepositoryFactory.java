package lk.ijse.DG.repository;


import lk.ijse.DG.repository.custom.impl.*;

public class RepositoryFactory {
    private static RepositoryFactory repositoryFactory;

    public static RepositoryFactory getInstance(){
        if(repositoryFactory == null){
            repositoryFactory = new RepositoryFactory();
        }
        return repositoryFactory;
    }

    public enum RepoTypes{
        RECEPTION,VEHICLE,TEST,TESTER,PAYMENT;
    }

    public <T> T getRepository(RepoTypes repoTypes){
        switch (repoTypes){
            case RECEPTION:
                return (T) new ReceptionRepoImpl();
            case VEHICLE:
                return (T) new VehicleRepoImpl();
            case TEST:
                return (T) new TestRepoImpl();
            case TESTER:
                return (T) new TesterRepoImpl();
            case PAYMENT:
                return (T) new PaymentRepoImpl();
            default:
                return null;
        }
    }
}
