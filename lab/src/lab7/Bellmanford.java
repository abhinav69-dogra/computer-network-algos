package lab7;
import java.util.*;
public class Bellmanford {
	static  double infinity=99;
	public static double[] bellmanford(double[][] mat,double[] distanceVector)
	{
		int n=distanceVector.length;
		double min;
		for(int i=0;i<n-1;i++)//no of nodes for which distance is to be calculated(4)
		{
			for(int j=0;j<n;j++)//traversing 2-d matrix to get min path
			{
				min=infinity;
				for(int k=0;k<n;k++)
				{
					if(min> mat[j][k]+distanceVector[k])
						min=mat[j][k]+distanceVector[k];
				}
				distanceVector[j]=min;
			}
		}
		return distanceVector;
		
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter no of Nodes ");
		int n=s.nextInt();
		double[][] mat=new double[n][n];
		System.out.println("Enter Adjancency Matrix (Use 999 for No Link");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				mat[i][j]=s.nextDouble();
			}
		}
		System.out.println("Enter Destination Node");
		int des=s.nextInt();
		double[] distanceVector=new double[n];
		for(int i=0;i<n;i++)
		{
	
			distanceVector[i]=infinity;
		}
		distanceVector[des-1]=0;
		distanceVector=bellmanford(mat, distanceVector);
		
		//Printing
		
		System.out.println("Distance Vector");
		for(int i=0;i<n;i++)
		{
			if(i==des-1)
				continue;
			System.out.println("Distance form "+(i+1)+" is :"+distanceVector[i]);
			
		}
		s.close();
}
}
